package ru.esstu.entrant.lk.services.forpdf;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.docx4j.Docx4J;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.EntrantDocTypeDto;
import ru.esstu.entrant.lk.domain.vo.*;
import ru.esstu.entrant.lk.domain.vo.Additionals.Keycloak;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;
import ru.esstu.entrant.lk.domain.vo.PublicTables.RelativeFather;
import ru.esstu.entrant.lk.domain.vo.PublicTables.RelativeMother;
import ru.esstu.entrant.lk.domain.vo.forpdf.*;
import ru.esstu.entrant.lk.repositories.*;
import ru.esstu.entrant.lk.repositories.PublicTables.*;
import ru.esstu.entrant.lk.repositories.forpdf.ForPDFRepository;
import ru.esstu.entrant.lk.repositories.forpdf.ReverseImportRepository;
import ru.esstu.entrant.lk.services.AccessService;
import ru.esstu.entrant.lk.services.reference.EntrantDocTypeRefService;
import ru.esstu.entrant.lk.utils.DateUtils;

import java.io.*;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    public DocxGeneratorService(
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
        //accessService.commonAccessCheck(entrantId);
        Keycloak keycloak = entrantRepository.getKeycloakGuid(entrantId);
        Person person = personPTRepository.getPerson(keycloak.getKeycloakGuid());
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<AdditionalInformationForPDF> additionalInformation = reverseImportRepository.getAdditionalInfoFromPublic(person.getPersonId());
        List<AdmissionInfoForPDF> admissionInfo = reverseImportRepository.getAdmissionInfoFromPublic(person.getPersonId());
        List<BenefitInformationForPDF> benefitInformation = reverseImportRepository.getBenefitInformationFromPublic(person.getPersonId());
        for (AdmissionInfoForPDF list:admissionInfo) {
            list.setDirectionName(forPDFRepository.getDirection(list.getSpecId()));
            list.setEduForm(forPDFRepository.getEduForm(list.getSpecId()));
            list.setLevelOfEducation(forPDFRepository.getEduLevel(list.getSpecId()));
        }
        Boolean olympiad=false;
        Boolean benefit=false;
        List<EntrantDocTypeDto> entrantDocTypes = entrantDocTypeRefService.getEntrantDocTypes();
        List<Integer> doc_id=new ArrayList<>();
        for (EntrantDocTypeDto doc:entrantDocTypes) {
            doc_id.add(doc.getDocTypeId());
        }
        for (BenefitInformationForPDF element:benefitInformation) {
            if(doc_id.contains(element.getDocTypeId())){
                benefit=true;
            }
            else{
                olympiad=true;
            }
        }
        ContactInformationForPDF contactInformation = reverseImportRepository.getContactFromPublic(person.getPersonId());
        EducationalAchievementsForPDF educationalAchievements= reverseImportRepository.getEducationalAchievementsFromPublic(person.getPersonId());
        EducationInfoForPDF educationInfo = reverseImportRepository.getEducInfoFromPublic(person.getPersonId());
        EntrantPrivateDataForPDF entrantPrivateData = reverseImportRepository.getEntrantPrivateDataFromPublic(person.getPersonId());
        PassportDataForPDF passportData = reverseImportRepository.getPassportDataFromPublic(person.getPersonId());
        RelativeMother relativeMother= relativeMotherPTRepository.getMotherId(person.getPersonId());
        RelativeFather relativeFather= relativeFatherPTRepository.getFatherId(person.getPersonId());
        List<ParentsInformationForPDF> parents= new ArrayList<>();
        // В РОДИТЕЛЯХ: НУЛЕВОЙ ЭЛЕМЕНТ - МАТЬ, ПЕРВЫЙ - ОТЕЦ. МЕСТО РАБОТЫ БЕРИ ИЗ RelativeMother И RelativeFather
        parents.add(reverseImportRepository.getParentsInfoFromPublic(relativeMother.getRealtiveId()));
        parents.add(reverseImportRepository.getParentsInfoFromPublic(relativeFather.getRealtiveId()));
        InputStream templateInputStream = this.getClass().getClassLoader().getResourceAsStream(TEMPLATE_NAME);
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(templateInputStream);
        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
        VariablePrepare.prepare(wordMLPackage);
        HashMap<String, String> variables = new HashMap<>();
        //Личные данные
        String FIO =entrantPrivateData.getName()+" "+entrantPrivateData.getSurname()+" "+entrantPrivateData.getPatronymic();
        variables.put("fio", FIO);
        if(entrantPrivateData.getMale())
        {
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
        String educ=forPDFRepository.getInstTypeName(educationInfo.getEduInstTypeId());
        variables.put("education", educ);
        variables.put("yearOfFinished", educationInfo.getEndYear().toString());
        String docEduc=forPDFRepository.getEduDocType(educationInfo.getEduDocTypeId());
        variables.put("docOfEducation", docEduc);
        String serialNumber = educationInfo.getDocSeries() + educationInfo.getDocNumber();
        variables.put("docOfEducationSerialNumber", serialNumber);
        variables.put("regionOfFinished", forPDFRepository.getRegion(educationInfo.getRegionId()));
        variables.put("districtOfFinished", forPDFRepository.getDistrict(educationInfo.getGraduationPlaceId()));
        String city=educationInfo.getCity();
        variables.put("cityOfFinished", city);
        variables.put("placeOfFinished", educationInfo.getEduInstName());
        variables.put("dateOfFinished", DateUtils.format(educationInfo.getDocDate(), "dd.MM.yyyy"));
        variables.put("language", forPDFRepository.getLanguage(educationInfo.getLangId()));
        //Инфо о месте жительства
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
        //Учебные достижения
        //medal - 2 Золотая, 3 серебряная
        if(educationalAchievements.getAchievementId()==null)
        {
            variables.put("medal", "-");
        }
        if(educationalAchievements.getAchievementId()==2)
        {
            variables.put("medal", "Золотая");
        }
        if(educationalAchievements.getAchievementId()==3)
        {
            variables.put("medal", "Серебряная");
        }
        if(olympiad) variables.put("olympiad", "Да");
        else variables.put("olympiad", "Нет");
        if(educationalAchievements.getSportQualificationId()==null) variables.put("sportQual", "-");
        else variables.put("sportQual", forPDFRepository.getSportQualification(educationalAchievements.getSportQualificationId()));
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
        if(contactInformation.getTelephone()==null)
        {
            variables.put("mobileNumber", "-");
        }
        else variables.put("mobileNumber", contactInformation.getTelephone());
        //Инфо о родителях
        variables.put("fatherName", parents.get(1).getName());
        variables.put("fatherSecondName", parents.get(1).getSurname());
        variables.put("fatherPatronymic", parents.get(1).getPatronymic());
        variables.put("fatherJob", relativeFather.getLabourPlace());
        variables.put("fatherNumber", parents.get(1).getTelephone());
        variables.put("motherName", parents.get(0).getName());
        variables.put("motherSecondName", parents.get(0).getSurname());
        variables.put("motherPatronymic", parents.get(0).getPatronymic());
        variables.put("motherJob", relativeMother.getLabourPlace());
        variables.put("motherNumber", parents.get(0).getTelephone());
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
        Docx4J.toPDF(wordMLPackage,outputStream);
        return outputStream.toByteArray();

    }

}

