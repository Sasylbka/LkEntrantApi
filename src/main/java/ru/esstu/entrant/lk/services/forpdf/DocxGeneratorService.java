package ru.esstu.entrant.lk.services.forpdf;

import lombok.extern.slf4j.Slf4j;
import org.docx4j.Docx4J;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFont;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.jaxb.Context;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.FontTablePart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.RFonts;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.EntrantDocTypeDto;
import ru.esstu.entrant.lk.domain.vo.Additionals.Keycloak;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;
import ru.esstu.entrant.lk.domain.vo.PublicTables.RelativeFather;
import ru.esstu.entrant.lk.domain.vo.PublicTables.RelativeMother;
import ru.esstu.entrant.lk.domain.vo.forpdf.*;
import ru.esstu.entrant.lk.exceptions.InvalidObjectException;
import ru.esstu.entrant.lk.repositories.ConsentRepository;
import ru.esstu.entrant.lk.repositories.EntrantRepository;
import ru.esstu.entrant.lk.repositories.PublicTables.PersonPTRepository;
import ru.esstu.entrant.lk.repositories.PublicTables.RelativeFatherPTRepository;
import ru.esstu.entrant.lk.repositories.PublicTables.RelativeMotherPTRepository;
import ru.esstu.entrant.lk.repositories.forpdf.ForPDFRepository;
import ru.esstu.entrant.lk.repositories.forpdf.ReverseImportRepository;
import ru.esstu.entrant.lk.services.AccessService;
import ru.esstu.entrant.lk.services.reference.EntrantDocTypeRefService;
import ru.esstu.entrant.lk.utils.DateUtils;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class DocxGeneratorService {
    private final AccessService accessService;
    private final EntrantRepository entrantRepository;
    private final ForPDFRepository forPDFRepository;
    private final ConsentRepository consentRepository;
    private final PersonPTRepository personPTRepository;
    private final ReverseImportRepository reverseImportRepository;
    private final RelativeMotherPTRepository relativeMotherPTRepository;
    private final RelativeFatherPTRepository relativeFatherPTRepository;
    private final EntrantDocTypeRefService entrantDocTypeRefService;

    public DocxGeneratorService (
            AccessService accessService,
            EntrantRepository entrantRepository,
            ForPDFRepository forPDFRepository,
            ConsentRepository consentRepository,
            PersonPTRepository personPTRepository,
            ReverseImportRepository reverseImportRepository, RelativeMotherPTRepository relativeMotherPTRepository, RelativeFatherPTRepository relativeFatherPTRepository, EntrantDocTypeRefService entrantDocTypeRefService) {

        this.entrantRepository = entrantRepository;
        this.accessService = accessService;
        this.forPDFRepository = forPDFRepository;
        this.consentRepository = consentRepository;
        this.personPTRepository = personPTRepository;
        this.reverseImportRepository = reverseImportRepository;
        this.relativeMotherPTRepository = relativeMotherPTRepository;
        this.relativeFatherPTRepository = relativeFatherPTRepository;
        this.entrantDocTypeRefService = entrantDocTypeRefService;
    }

    private static final String TEMPLATE_NAME = "files/template.docx";

    @Transactional
    public byte[] generateDocxFileFromTemplate(final int entrantId) throws Exception {
        accessService.commonAccessCheck(entrantId);
        Keycloak keycloak = entrantRepository.getKeycloakGuid(entrantId);
        Person person = personPTRepository.getPerson(keycloak.getKeycloakGuid());
        if(person==null){
            throw new InvalidObjectException("Этот пользователь не импортирован");
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<AdditionalInformationForPDF> additionalInformation = reverseImportRepository.getAdditionalInfoFromPublic(person.getPersonId());
        List<AdmissionInfoForPDF> admissionInfo = reverseImportRepository.getAdmissionInfoFromPublic(person.getPersonId());
        List<BenefitInformationForPDF> benefitInformation = reverseImportRepository.getBenefitInformationFromPublic(person.getPersonId());
        for (AdmissionInfoForPDF list : admissionInfo) {
            list.setDirectionName(forPDFRepository.getDirection(list.getSpecId()));
            list.setEduForm(forPDFRepository.getEduForm(list.getSpecId()));
            list.setLevelOfEducation(forPDFRepository.getEduLevel(list.getSpecId()));
        }
        Boolean olympiad = false;
        Boolean benefit = false;
        List<EntrantDocTypeDto> entrantDocTypes = entrantDocTypeRefService.getEntrantDocTypes();
        List<Integer> doc_id = new ArrayList<>();
        for (EntrantDocTypeDto doc : entrantDocTypes) {
            doc_id.add(doc.getDocTypeId());
        }
        if(benefitInformation.size()>0) {
            for (BenefitInformationForPDF element : benefitInformation) {
                if (doc_id.contains(element.getDocTypeId())) {
                    benefit = true;
                } else {
                    olympiad = true;
                }
            }
        }
        ContactInformationForPDF contactInformation = reverseImportRepository.getContactFromPublic(person.getPersonId());
        EducationalAchievementsForPDF educationalAchievements = reverseImportRepository.getEducationalAchievementsFromPublic(person.getPersonId());
        EducationInfoForPDF educationInfo = reverseImportRepository.getEducInfoFromPublic(person.getPersonId());
        EntrantPrivateDataForPDF entrantPrivateData = reverseImportRepository.getEntrantPrivateDataFromPublic(person.getPersonId());
        PassportDataForPDF passportData = reverseImportRepository.getPassportDataFromPublic(person.getPersonId());
        RelativeMother relativeMother = relativeMotherPTRepository.getMotherId(person.getPersonId());
        RelativeFather relativeFather = relativeFatherPTRepository.getFatherId(person.getPersonId());
        ParentsInformationForPDF motherInfo = null;
        ParentsInformationForPDF fatherInfo = null;
        //МЕСТО РАБОТЫ БЕРИ ИЗ RelativeMother И RelativeFather
        if (relativeMother != null) {
            motherInfo = reverseImportRepository.getParentsInfoFromPublic(relativeMother.getRealtiveId());
        }
        if (relativeFather != null) {
            fatherInfo = reverseImportRepository.getParentsInfoFromPublic(relativeFather.getRealtiveId());
        }
        InputStream templateInputStream = this.getClass().getClassLoader().getResourceAsStream(TEMPLATE_NAME);
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(templateInputStream);
        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
        VariablePrepare.prepare(wordMLPackage);
        HashMap<String, String> variables = new HashMap<>();
        //Личные данные
        String fio = entrantPrivateData.getSurname() + " " + entrantPrivateData.getName() + " " + entrantPrivateData.getPatronymic();
        variables.put("fio", fio);
        if (entrantPrivateData.getMale()) {
            variables.put("gender", "Мужчина");
        } else variables.put("gender", "Женщина");
        variables.put("dateOfBirth", DateUtils.format(entrantPrivateData.getBirthdate(), "dd.MM.yyyy"));
        variables.put("regionOfBirth", entrantPrivateData.getBirthRegion());
        variables.put("cityOfBirth", entrantPrivateData.getBirthCity());
        variables.put("snills", entrantPrivateData.getSnils());
        //Паспортные данные
        variables.put("serial", passportData.getDocSeries());
        variables.put("number", passportData.getDocNumber());
        variables.put("placeOfIssue", passportData.getReleasingOrgName());
        variables.put("dateOfIssue", DateUtils.format(passportData.getReleaseDate(), "dd.MM.yyyy"));
        variables.put("codeOfSubdivision", passportData.getDepartmentCode());
        //Инфо об образования
        String educ = forPDFRepository.getInstTypeName(educationInfo.getEduInstTypeId());
        variables.put("education", educ);
        variables.put("yearOfFinished", educationInfo.getEndYear().toString());
        String docEduc = forPDFRepository.getEduDocType(educationInfo.getEduDocTypeId());
        variables.put("docOfEducation", docEduc);
        String serialNumber = educationInfo.getDocSeries() + educationInfo.getDocNumber();
        variables.put("docOfEducationSerialNumber", serialNumber);
        variables.put("regionOfFinished", forPDFRepository.getRegion(educationInfo.getRegionId()));
        variables.put("districtOfFinished", forPDFRepository.getDistrict(educationInfo.getGraduationPlaceId()));
        String city = educationInfo.getCity();
        variables.put("cityOfFinished", city);
        variables.put("placeOfFinished", educationInfo.getEduInstName());
        variables.put("dateOfFinished", DateUtils.format(educationInfo.getDocDate(), "dd.MM.yyyy"));
        variables.put("language", forPDFRepository.getLanguage(educationInfo.getLangId()));
        //Инфо о месте жительства
        if(additionalInformation.size()==1){
            variables.put("region", forPDFRepository.getRegion(additionalInformation.get(0).getRegionId()));
            variables.put("city", additionalInformation.get(0).getCity());
            variables.put("street", additionalInformation.get(0).getStreet());
            variables.put("numOfBuilding", additionalInformation.get(0).getBuildingNum());
            variables.put("numOfApartments", additionalInformation.get(0).getFlatNum());
            variables.put("index", additionalInformation.get(0).getIndex());
            variables.put("coincides", "Да");
        }
        else {
            if (additionalInformation.get(0).getAddressTypeId() == 1) {
                variables.put("region", forPDFRepository.getRegion(additionalInformation.get(0).getRegionId()));
                variables.put("city", additionalInformation.get(0).getCity());
                variables.put("street", additionalInformation.get(0).getStreet());
                variables.put("numOfBuilding", additionalInformation.get(0).getBuildingNum());
                variables.put("numOfApartments", additionalInformation.get(0).getFlatNum());
                variables.put("index", additionalInformation.get(0).getIndex());
            } else {
                variables.put("region", forPDFRepository.getRegion(additionalInformation.get(1).getRegionId()));
                variables.put("area", forPDFRepository.getDistrict(additionalInformation.get(1).getDistrictId()));
                variables.put("city", additionalInformation.get(1).getCity());
                variables.put("street", additionalInformation.get(1).getStreet());
                variables.put("numOfBuilding", additionalInformation.get(1).getBuildingNum());
                variables.put("numOfApartments", additionalInformation.get(1).getFlatNum());
                variables.put("index", additionalInformation.get(1).getIndex());
            }
            if (additionalInformation.get(0).getIndex().equals(additionalInformation.get(1).getIndex())
                    && additionalInformation.get(0).getFlatNum().equals(additionalInformation.get(1).getFlatNum())
                    && additionalInformation.get(0).getStreet().equals(additionalInformation.get(1).getStreet())
                    && additionalInformation.get(0).getBuildingNum().equals(additionalInformation.get(1).getBuildingNum()))
                variables.put("coincides", "Да");
            else {
                variables.put("coincides", "Нет");
            }
        }
        //Учебные достижения
        //medal - 2 Золотая, 3 серебряная
        if (educationalAchievements.getAchievementId() == null) {
            variables.put("medal", "-");
        }
        if (educationalAchievements.getAchievementId() == 2) {
            variables.put("medal", "Золотая");
        }
        if (educationalAchievements.getAchievementId() == 3) {
            variables.put("medal", "Серебряная");
        }
        if (olympiad) variables.put("olympiad", "Да");
        else variables.put("olympiad", "Нет");
        if (educationalAchievements.getSportQualificationId() == null) variables.put("sportQual", "-");
        else
            variables.put("sportQual", forPDFRepository.getSportQualification(educationalAchievements.getSportQualificationId()));
        //Доп. инфо
        if (benefit)
            variables.put("haveBenefit", "Да");
        else {
            variables.put("haveBenefit", "Нет");
        }
        String reservist = "";
        if (entrantPrivateData.getMilitaryStatusId() == 1) reservist = "Нет";
        else reservist = "Да";
        variables.put("reservist", reservist);
        String needsHostel = "";
        if (entrantPrivateData.getNeedHostel()) needsHostel = "Да";
        else needsHostel = "Нет";
        variables.put("needsHostel", needsHostel);
        //Контактная информация
        if (contactInformation.getTelephone() == null) {
            variables.put("mobileNumber", "-");
        } else variables.put("mobileNumber", contactInformation.getTelephone());
        //Инфо о родителях
        if (fatherInfo != null )
        { variables.put("fatherName", fatherInfo.getName());
        variables.put("fatherSecondName", fatherInfo.getSurname());
        variables.put("fatherPatronymic", fatherInfo.getPatronymic());
        variables.put("fatherNumber", fatherInfo.getTelephone());
        }
        else {
            variables.put("fatherName", "-");
            variables.put("fatherSecondName", "-");
            variables.put("fatherPatronymic", "-");
            variables.put("fatherNumber", "-");
        }
        if(relativeFather!=null){
            variables.put("fatherJob", relativeFather.getLabourPlace());
        }
        else {
            variables.put("fatherJob", "-");
        }
        if(motherInfo != null )
        { variables.put("motherName", motherInfo.getName());
            variables.put("motherSecondName", motherInfo.getSurname());
            variables.put("motherPatronymic", motherInfo.getPatronymic());
            variables.put("motherNumber", motherInfo.getTelephone());
        }
        else {
            variables.put("motherName", "-");
            variables.put("motherSecondName", "-");
            variables.put("motherPatronymic", "-");
            variables.put("motherNumber", "-");
        }
        if(relativeMother!=null){
            variables.put("motherJob", relativeMother.getLabourPlace());
        }
        else {
            variables.put("motherJob", "-");
        }
        //Направления обучения
        if (admissionInfo.size() != 0) {
            //1 Направление
            variables.put("firstAILevel", admissionInfo.get(0).getLevelOfEducation());
            variables.put("firstDirection", admissionInfo.get(0).getDirectionName());
            variables.put("firstEduForm", admissionInfo.get(0).getEduForm());
            //2 Направление
            if (admissionInfo.size() > 1) {
                variables.put("secondAILevel", admissionInfo.get(1).getLevelOfEducation());
                variables.put("secondDirection", admissionInfo.get(1).getDirectionName());
                variables.put("secondEduForm", admissionInfo.get(1).getEduForm());
                //3 Направление
                if (admissionInfo.size() == 3) {
                    variables.put("thirdAILevel", admissionInfo.get(2).getLevelOfEducation());
                    variables.put("thirdDirection", admissionInfo.get(2).getDirectionName());
                    variables.put("thirdEduForm", admissionInfo.get(2).getEduForm());

                } else {
                    variables.put("thirdAILevel", "-");
                    variables.put("thirdDirection", "-");
                    variables.put("thirdEduForm", "-");

                }
            } else {
                variables.put("secondAILevel", "-");
                variables.put("secondDirection", "-");
                variables.put("secondEduForm", "-");

                variables.put("thirdAILevel", "-");
                variables.put("thirdDirection", "-");
                variables.put("thirdEduForm", "-");

            }

        }
        //Активное согласие
        String cAI="-";
        String cD="-";
        String cEF="-";
        String d="-";
        for(AdmissionInfoForPDF value:admissionInfo)
        {
            if(value.isOriginalEduDocument())
            {
                cAI=value.getLevelOfEducation();
                cD=value.getDirectionName();
                cEF=value.getEduForm();
                d=DateUtils.format(value.getRegisteredOn(), "dd.MM.yyyy");
            }
        }
        variables.put("consentAILevel", cAI);
        variables.put("consentDirection", cD);
        variables.put("consentEduForm", cEF);
        variables.put("consentData", d);
        documentPart.variableReplace(variables);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //wordMLPackage.save(outputStream);
        Mapper fontMapper = new IdentityPlusMapper();
        String fontFamily = "Arial";
        URL simsunUrl = Thread.currentThread().getContextClassLoader().getResource("files/arial.ttf");
        PhysicalFonts.addPhysicalFonts(fontFamily, simsunUrl);
        PhysicalFont simsunFont = PhysicalFonts.get(fontFamily);
//        FontTablePart fontTablePart= wordMLPackage.getMainDocumentPart().getFontTablePart();
//        fontTablePart.processEmbeddings();
//        Set<String> fontsInUse = wordMLPackage.getMainDocumentPart().fontsInUse();
//         Make each embedded font available to the font mapper.
//        for(String s : fontsInUse) {
//            PhysicalFont physicalFont = PhysicalFonts.get(s);
//            fontMapper.put(s, physicalFont);
//        }
        // Now you can access your fonts, such as 'Comic Sans' or 'Arial Unicode MS'.
        //PhysicalFont font = PhysicalFonts.getPhysicalFonts().get(
                //"");
        //fontMapper.put(Mapper.FONT_FALLBACK, font);
        fontMapper.put(fontFamily, simsunFont);
        RFonts rfonts = Context.getWmlObjectFactory().createRFonts();
        rfonts.setAsciiTheme(null);
        rfonts.setAscii(fontFamily);
        wordMLPackage.getMainDocumentPart().getPropertyResolver()
                .getDocumentDefaultRPr().setRFonts(rfonts);
        Docx4J.toPDF(wordMLPackage,outputStream);
        return outputStream.toByteArray();
    }

}

