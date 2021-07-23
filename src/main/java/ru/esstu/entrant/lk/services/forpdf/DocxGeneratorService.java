package ru.esstu.entrant.lk.services.forpdf;

import fr.opensagres.odfdom.converter.pdf.PdfOptions;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.docx4j.Docx4J;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFont;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.FontTablePart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.stereotype.Service;
import org.testcontainers.shaded.com.google.common.io.Files;
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
import java.net.URL;
import java.util.*;

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
    private static final String PDF_NAME = "PDF/file.pdf";

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
        //InputStream templateInputStream = this.getClass().getClassLoader().getResourceAsStream(TEMPLATE_NAME);
        //WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(templateInputStream);
        //MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
        //VariablePrepare.prepare(wordMLPackage);

        InputStream in = this.getClass().getClassLoader().getResourceAsStream(TEMPLATE_NAME);
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
        IContext context = report.createContext();

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Личные данные
        String FIO =entrantPrivateData.getName()+" "+entrantPrivateData.getSurname()+" "+entrantPrivateData.getPatronymic();
        context.put("fio", FIO);
        if(entrantPrivateData.getMale())
        {
            context.put("gender", "Мужчина");
        } else context.put("gender", "Женщина");
        context.put("dateOfBirth", DateUtils.format(entrantPrivateData.getBirthdate(), "dd.MM.yyyy"));
        context.put("regionOfBirth", entrantPrivateData.getBirthRegion());
        context.put("cityOfBirth", entrantPrivateData.getBirthCity());
        context.put("snills", entrantPrivateData.getSnils());
        //Паспортные данные
        context.put("serial", passportData.getDocSeries());
        context.put("number", passportData.getDocNumber());
        context.put("placeOfIssue", passportData.getReleasingOrgName());
        context.put("dateOfIssue", DateUtils.format(passportData.getReleaseDate(), "dd.MM.yyyy"));
        context.put("codeOfSubdivision", passportData.getDepartmentCode());
        //Инфо об образования
        String educ=forPDFRepository.getInstTypeName(educationInfo.getEduInstTypeId());
        context.put("education", educ);
        context.put("yearOfFinished", educationInfo.getEndYear().toString());
        String docEduc=forPDFRepository.getEduDocType(educationInfo.getEduDocTypeId());
        context.put("docOfEducation", docEduc);
        String serialNumber = educationInfo.getDocSeries() + educationInfo.getDocNumber();
        context.put("docOfEducationSerialNumber", serialNumber);
        context.put("regionOfFinished", forPDFRepository.getRegion(educationInfo.getRegionId()));
        context.put("districtOfFinished", forPDFRepository.getDistrict(educationInfo.getGraduationPlaceId()));
        String city=educationInfo.getCity();
        context.put("cityOfFinished", city);
        context.put("placeOfFinished", educationInfo.getEduInstName());
        context.put("dateOfFinished", DateUtils.format(educationInfo.getDocDate(), "dd.MM.yyyy"));
        context.put("language", forPDFRepository.getLanguage(educationInfo.getLangId()));
        //Инфо о месте жительства
        if (additionalInformation.get(0).getAddressTypeId() == 1) {
            context.put("region", forPDFRepository.getRegion(additionalInformation.get(0).getRegionId()));
            context.put("city", additionalInformation.get(0).getCity());
            context.put("street", additionalInformation.get(0).getStreet());
            context.put("numOfBuilding", additionalInformation.get(0).getBuildingNum());
            context.put("numOfApartments", additionalInformation.get(0).getFlatNum());
            context.put("index", additionalInformation.get(0).getIndex());
        } else {
            context.put("region", forPDFRepository.getRegion(additionalInformation.get(1).getRegionId()));
            context.put("area", forPDFRepository.getDistrict(additionalInformation.get(1).getDistrictId()));
            context.put("city", additionalInformation.get(1).getCity());
            context.put("street", additionalInformation.get(1).getStreet());
            context.put("numOfBuilding", additionalInformation.get(1).getBuildingNum());
            context.put("numOfApartments", additionalInformation.get(1).getFlatNum());
            context.put("index", additionalInformation.get(1).getIndex());
        }
        if (additionalInformation.get(0).getIndex().equals(additionalInformation.get(1).getIndex())
                && additionalInformation.get(0).getFlatNum().equals(additionalInformation.get(1).getFlatNum())
                && additionalInformation.get(0).getStreet().equals(additionalInformation.get(1).getStreet())
                && additionalInformation.get(0).getBuildingNum().equals(additionalInformation.get(1).getBuildingNum()))
            context.put("coincides", "Да");
        else {
            context.put("coincides", "Нет");
        }
        //Учебные достижения
        //medal - 2 Золотая, 3 серебряная
        if(educationalAchievements.getAchievementId()==null)
        {
            context.put("medal", "-");
        }
        if(educationalAchievements.getAchievementId()==2)
        {
            context.put("medal", "Золотая");
        }
        if(educationalAchievements.getAchievementId()==3)
        {
            context.put("medal", "Серебряная");
        }
        if(olympiad) context.put("olympiad", "Да");
        else context.put("olympiad", "Нет");
        if(educationalAchievements.getSportQualificationId()==null) context.put("sportQual", "-");
        else context.put("sportQual", forPDFRepository.getSportQualification(educationalAchievements.getSportQualificationId()));
        //Доп. инфо
        if (benefit)
            context.put("haveBenefit", "Да");
        else {
            context.put("haveBenefit", "Нет");
        }
        String reservist = "";
        if (entrantPrivateData.getMilitaryStatusId() == 1) reservist = "Нет";
        else reservist = "Да";
        context.put("reservist", reservist);
        String needsHostel = "";
        if (entrantPrivateData.getNeedHostel()) needsHostel = "Да";
        else needsHostel = "Нет";
        context.put("needsHostel", needsHostel);
        //Контактная информация
        if(contactInformation.getTelephone()==null)
        {
            context.put("mobileNumber", "-");
        }
        else context.put("mobileNumber", contactInformation.getTelephone());
        //Инфо о родителях
        context.put("fatherName", parents.get(1).getName());
        context.put("fatherSecondName", parents.get(1).getSurname());
        context.put("fatherPatronymic", parents.get(1).getPatronymic());
        context.put("fatherJob", relativeFather.getLabourPlace());
        context.put("fatherNumber", parents.get(1).getTelephone());
        context.put("motherName", parents.get(0).getName());
        context.put("motherSecondName", parents.get(0).getSurname());
        context.put("motherPatronymic", parents.get(0).getPatronymic());
        context.put("motherJob", relativeMother.getLabourPlace());
        context.put("motherNumber", parents.get(0).getTelephone());
        //Направления обучения
        if (admissionInfo.size() != 0) {
            //1 Направление
            context.put("firstAILevel", admissionInfo.get(0).getLevelOfEducation());
            context.put("firstDirection", admissionInfo.get(0).getDirectionName());
            context.put("firstEduForm", admissionInfo.get(0).getEduForm());
            //2 Направление
            if (admissionInfo.size() > 1) {
                context.put("secondAILevel", admissionInfo.get(1).getLevelOfEducation());
                context.put("secondDirection", admissionInfo.get(1).getDirectionName());
                context.put("secondEduForm", admissionInfo.get(1).getEduForm());
                //3 Направление
                if (admissionInfo.size() == 3) {
                    context.put("thirdAILevel", admissionInfo.get(2).getLevelOfEducation());
                    context.put("thirdDirection", admissionInfo.get(2).getDirectionName());
                    context.put("thirdEduForm", admissionInfo.get(2).getEduForm());

                } else {
                    context.put("thirdAILevel", "-");
                    context.put("thirdDirection", "-");
                    context.put("thirdEduForm", "-");

                }
            } else {
                context.put("secondAILevel", "-");
                context.put("secondDirection", "-");
                context.put("secondEduForm", "-");

                context.put("thirdAILevel", "-");
                context.put("thirdDirection", "-");
                context.put("thirdEduForm", "-");

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
        context.put("consentAILevel", cAI);
        context.put("consentDirection", cD);
        context.put("consentEduForm", cEF);
        context.put("consentData", d);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //documentPart.variableReplace(context);
        //InputStream docxFile = new FileInputStream(Objects.requireNonNull(this.getClass().getResourceAsStream(TEMP_NAME));
        Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.XWPF);
        PdfOptions pdfOptions = PdfOptions.create();
        pdfOptions.fontEncoding("Cp1251");
        options.subOptions(pdfOptions);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        report.convert(context,options,outputStream);
        return outputStream.toByteArray();
    }

}

