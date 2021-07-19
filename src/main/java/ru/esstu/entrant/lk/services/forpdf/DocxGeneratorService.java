package ru.esstu.entrant.lk.services.forpdf;

import lombok.extern.slf4j.Slf4j;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.vo.*;
import ru.esstu.entrant.lk.domain.vo.Additionals.Keycloak;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;
import ru.esstu.entrant.lk.domain.vo.forpdf.AdditionalInformationForPDF;
import ru.esstu.entrant.lk.domain.vo.forpdf.EducationInfoForPDF;
import ru.esstu.entrant.lk.domain.vo.forpdf.EntrantPrivateDataForPDF;
import ru.esstu.entrant.lk.repositories.*;
import ru.esstu.entrant.lk.repositories.PublicTables.*;
import ru.esstu.entrant.lk.repositories.forpdf.ForPDFRepository;
import ru.esstu.entrant.lk.repositories.forpdf.ReverseImportRepository;
import ru.esstu.entrant.lk.services.AccessService;
import ru.esstu.entrant.lk.utils.DateUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.transaction.Transactional;
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

    public DocxGeneratorService(
            AccessService accessService,
            EntrantRepository entrantRepository,
            ForPDFRepository forPDFRepository,
            ConsentRepository consentRepository,
            PersonPTRepository personPTRepository,
            ReverseImportRepository reverseImportRepository) {

        this.entrantRepository = entrantRepository;
        this.accessService = accessService;
        this.forPDFRepository = forPDFRepository;
        this.consentRepository = consentRepository;
        this.personPTRepository = personPTRepository;
        this.reverseImportRepository = reverseImportRepository;
    }

    private static final String TEMPLATE_NAME = "files/template.docx";

    @Transactional
    public byte[] generateDocxFileFromTemplate(final int entrantId) throws Exception {
        //accessService.commonAccessCheck(entrantId);
        Keycloak keycloak = entrantRepository.getKeycloakGuid(entrantId);
        Person person = personPTRepository.getPerson(keycloak.getKeycloakGuid());
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<AdditionalInformationForPDF> additionalInformation = reverseImportRepository.getAdditionalInfoFromPublic(person.getPersonId());
        List<AdmissionInfo> admissionInfo = ;
        BenefitInformation benefitInformation = ;
        ContactInformation contactInformation = reverseImportRepository.getContactFromPublic(person.getPersonId());
        List<EducationalAchievements> educationalAchievements = ;
        EducationInfoForPDF educationInfo = reverseImportRepository.getEducInfoFromPublic(person.getPersonId());
        EntrantPrivateDataForPDF entrantPrivateData = reverseImportRepository.getEntrantPrivateDataFromPublic(person.getPersonId());
        PassportData passportData = reverseImportRepository.getPassportDataFromPublic(person.getPersonId());
        ParentsInformation parentsInformation = ;
        List<Consent> consent = ;
        InputStream templateInputStream = this.getClass().getClassLoader().getResourceAsStream(TEMPLATE_NAME);
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(templateInputStream);
        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
        VariablePrepare.prepare(wordMLPackage);
        HashMap<String, String> variables = new HashMap<>();
        //Личные данные
        variables.put("name", entrantPrivateData.getName());
        variables.put("familyName", entrantPrivateData.getFamilyName());
        variables.put("patronymic", entrantPrivateData.getPatronymic());
        variables.put("gender", entrantPrivateData.getGender());
        variables.put("dateOfBirth", DateUtils.format(entrantPrivateData.getDateOfBirth(), "dd.MM.yyyy"));
        variables.put("regionOfBirth", entrantPrivateData.getRegionOfBirth());
        variables.put("cityOfBirth", entrantPrivateData.getCityOfBirth());
        variables.put("snills", entrantPrivateData.getSnills());
        //Паспортные данные
        variables.put("series", passportData.getSeries());
        variables.put("number", passportData.getNumber());
        variables.put("placeOfIssue", passportData.getPlaceOfIssue());
        variables.put("dateOfIssue", DateUtils.format(passportData.getDateOfIssue(), "dd.MM.yyyy"));
        variables.put("codeOfSubdivision", passportData.getCodeOfSubdivision());
        //Инфо об образования
        variables.put("education", forPDFRepository.getInstTypeName(educationInfo.getEducation()));
        variables.put("yearOfFinished", educationInfo.getYearOfFinished().toString());
        variables.put("docOfEducation", educationInfo.getDocumentOfEducation());
        String serialNumber = educationInfo.getSerial() + educationInfo.getNumber();
        variables.put("docOfEducationSerialNumber", serialNumber);
        variables.put("regionOfFinished", forPDFRepository.getRegion(educationInfo.getRegionOfFinished()));
        variables.put("districtOfFinished", forPDFRepository.getDistrict(educationInfo.getDistrictOfFinished()));
        variables.put("cityOfFinished", educationInfo.getCity());
        variables.put("placeOfFinished", educationInfo.getPlaceOfFinished());
        variables.put("dateOfFinished", DateUtils.format(educationInfo.getDateOfFinished(), "dd.MM.yyyy"));
        variables.put("language", forPDFRepository.getLanguage(educationInfo.getStudiedLanguage()));
        //Инфо о месте жительства
        if (additionalInformation.get(0).getType() == 1) {
            variables.put("region", forPDFRepository.getRegion(additionalInformation.get(0).getRegion()));
            variables.put("area", forPDFRepository.getDistrict(additionalInformation.get(0).getArea()));
            variables.put("city", additionalInformation.get(0).getCity());
            variables.put("street", additionalInformation.get(0).getStreet());
            variables.put("numOfBuilding", additionalInformation.get(0).getNumberOfBuilding());
            variables.put("numOfApartments", additionalInformation.get(0).getNumberOfApartments());
            variables.put("index", additionalInformation.get(0).getIndex());
        } else {
            variables.put("region", forPDFRepository.getRegion(additionalInformation.get(1).getRegion()));
            variables.put("area", forPDFRepository.getDistrict(additionalInformation.get(1).getArea()));
            variables.put("city", additionalInformation.get(1).getCity());
            variables.put("street", additionalInformation.get(1).getStreet());
            variables.put("numOfBuilding", additionalInformation.get(1).getNumberOfBuilding());
            variables.put("numOfApartments", additionalInformation.get(1).getNumberOfApartments());
            variables.put("index", additionalInformation.get(1).getIndex());
        }
        if (additionalInformation.get(0).getIndex().equals(additionalInformation.get(1).getIndex())
                && additionalInformation.get(0).getNumberOfApartments().equals(additionalInformation.get(1).getNumberOfApartments())
                && additionalInformation.get(0).getStreet().equals(additionalInformation.get(1).getStreet())
                && additionalInformation.get(0).getNumberOfBuilding().equals(additionalInformation.get(1).getNumberOfBuilding()))
            variables.put("coincides", "Да");
        else {
            variables.put("coincides", "Нет");
        }
        //Учебные достижения
        variables.put("medal", educationalAchievements.get(0).getMedal());
        variables.put("olympiad", educationalAchievements.get(0).getOlympiadParticipation());
        variables.put("sportQual", "-");
        //Доп. инфо
        if (benefitInformation.getBenefitChecked() == true)
            variables.put("haveBenefit", "Да");
        else {
            variables.put("haveBenefit", "Нет");
        }
        String reservist = "";
        if (entrantPrivateData.getReservist() == 1) reservist = "Нет";
        else reservist = "Да";
        variables.put("reservist", reservist);
        String needsHostel = "";
        if (entrantPrivateData.getNeedsHostel()) needsHostel = "Да";
        else needsHostel = "Нет";
        variables.put("needsHostel", needsHostel);
        //Контактная информация
        variables.put("mobileNumber", contactInformation.getMobileNumber());
        //Инфо о родителях
        variables.put("fatherName", parentsInformation.getFatherName());
        variables.put("fatherSecondName", parentsInformation.getFatherSecondName());
        variables.put("fatherPatronymic", parentsInformation.getFatherPatronymic());
        variables.put("fatherJob", parentsInformation.getPlaceOfFatherJob());
        variables.put("fatherNumber", parentsInformation.getFatherMobileNumber());
        variables.put("motherName", parentsInformation.getMotherName());
        variables.put("motherSecondName", parentsInformation.getMotherSecondName());
        variables.put("motherPatronymic", parentsInformation.getMotherPatronymic());
        variables.put("motherJob", parentsInformation.getPlaceOfMotherJob());
        variables.put("motherNumber", parentsInformation.getMotherMobileNumber());
        //Направления обучения
        if (admissionInfo.size() != 0) {
            //1 Направление
            variables.put("firstAILevel", admissionInfo.get(0).getLevelOfEducation());
            variables.put("firstDirection", forPDFRepository.getDirection(Integer.parseInt(admissionInfo.get(0).getDirection())));
            variables.put("firstEduForm", forPDFRepository.getEduForm(Integer.parseInt(admissionInfo.get(0).getDirection())));
            String firstFormOfFin = "";
            if (admissionInfo.get(0).isBudget()) {
                firstFormOfFin += "бюджет";
            }
            if (admissionInfo.get(0).isTargetedTraining()) {
                if (!firstFormOfFin.equals("")) {
                    firstFormOfFin += ", целевое обучение";
                } else firstFormOfFin += "целевое обучение";
            }
            if (admissionInfo.get(0).isQuota()) {
                if (!firstFormOfFin.equals("")) {
                    firstFormOfFin += ", особые права";
                } else firstFormOfFin += "особые права";
            }
            if (admissionInfo.get(0).isContract()) {
                if (!firstFormOfFin.equals("")) {
                    firstFormOfFin += ", договор";
                } else firstFormOfFin += "договор";
            }
            variables.put("firstFormOfFin", firstFormOfFin);
            //2 Направление
            if (admissionInfo.size() > 1) {
                variables.put("secondAILevel", admissionInfo.get(1).getLevelOfEducation());
                variables.put("secondDirection", forPDFRepository.getDirection(Integer.parseInt(admissionInfo.get(1).getDirection())));
                variables.put("secondEduForm", forPDFRepository.getEduForm(Integer.parseInt(admissionInfo.get(1).getDirection())));
                String secondFormOfFin = "";
                if (admissionInfo.get(1).isBudget()) {
                    secondFormOfFin += "бюджет";
                }
                if (admissionInfo.get(1).isTargetedTraining()) {
                    if (!secondFormOfFin.equals("")) {
                        secondFormOfFin += ", целевое обучение";
                    } else secondFormOfFin += "целевое обучение";
                }
                if (admissionInfo.get(1).isQuota()) {
                    if (!secondFormOfFin.equals("")) {
                        secondFormOfFin += ", особые права";
                    } else secondFormOfFin += "особые права";
                }
                if (admissionInfo.get(1).isContract()) {
                    if (!secondFormOfFin.equals("")) {
                        secondFormOfFin += ", договор";
                    } else secondFormOfFin += "договор";
                }
                variables.put("secondFormOfFin", secondFormOfFin);
                //3 Направление
                if (admissionInfo.size() == 3) {
                    variables.put("thirdAILevel", admissionInfo.get(2).getLevelOfEducation());
                    variables.put("thirdDirection", forPDFRepository.getDirection(Integer.parseInt(admissionInfo.get(2).getDirection())));
                    variables.put("thirdEduForm", forPDFRepository.getEduForm(Integer.parseInt(admissionInfo.get(2).getDirection())));
                    String thirdFormOfFin = "";
                    if (admissionInfo.get(2).isBudget()) {
                        thirdFormOfFin += "бюджет";
                    }
                    if (admissionInfo.get(2).isTargetedTraining()) {
                        if (!thirdFormOfFin.equals("")) {
                            thirdFormOfFin += ", целевое обучение";
                        } else thirdFormOfFin += "целевое обучение";
                    }
                    if (admissionInfo.get(2).isQuota()) {
                        if (!thirdFormOfFin.equals("")) {
                            thirdFormOfFin += ", особые права";
                        } else thirdFormOfFin += "особые права";
                    }
                    if (admissionInfo.get(2).isContract()) {
                        if (!thirdFormOfFin.equals("")) {
                            thirdFormOfFin += ", договор";
                        } else thirdFormOfFin += "договор";
                    }
                    variables.put("thirdFormOfFin", thirdFormOfFin);
                } else {
                    variables.put("thirdAILevel", "-");
                    variables.put("thirdDirection", "-");
                    variables.put("thirdEduForm", "-");
                    variables.put("thirdFormOfFin", "-");
                }
            } else {
                variables.put("secondAILevel", "-");
                variables.put("secondDirection", "-");
                variables.put("secondEduForm", "-");
                variables.put("secondFormOfFin", "-");
                variables.put("thirdAILevel", "-");
                variables.put("thirdDirection", "-");
                variables.put("thirdEduForm", "-");
                variables.put("thirdFormOfFin", "-");
            }

        }
        //Активное согласие
        //Доделать
        variables.put("consentAILevel", "-");
        variables.put("consentDirection", "-");
        variables.put("consentEduForm", "-");
        variables.put("consentFormOfFin", "-");
        documentPart.variableReplace(variables);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        wordMLPackage.save(outputStream);
        return outputStream.toByteArray();
    }

}

