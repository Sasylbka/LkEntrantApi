package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.vo.*;
import ru.esstu.entrant.lk.domain.vo.Additionals.Keycloak;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;
import ru.esstu.entrant.lk.domain.vo.reference.Speciality;
import ru.esstu.entrant.lk.exceptions.AlreadyHaveException;
import ru.esstu.entrant.lk.repositories.*;
import ru.esstu.entrant.lk.repositories.PublicTables.*;
import ru.esstu.entrant.lk.repositories.reference.*;
import ru.esstu.entrant.lk.utils.IdFactory;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class AcceptAnketaService {
    private final AdmissionInfoRepository admissionInfoRepository;
    private final AccessService accessService;
    private final AdditionalInformationRepository additionalInformationRepository;
    private final BenefitInformationRepository benefitInformationRepository;
    private final ChangesDateRepository changesDateRepository;
    private final ContactInformationRepository contactInformationRepository;
    private final EducationalAchievementsRepository educationalAchievementsRepository;
    private final EducationInfoRepository educationInfoRepository;
    private final EntrantPrivateDataRepository entrantPrivateDataRepository;
    private final EntrantRepository entrantRepository;
    private final JobInformationRepository jobInformationRepository;
    private final ParentsInformationRepository parentsInformationRepository;
    private final PassportDataRepository passportDataRepository;
    private final AcceptAnketaRepository acceptAnketaRepository;
    private final PersonPTRepository personPTRepository;
    private final RelativeFatherPTRepository relativeFatherPTRepository;
    private final RelativeMotherPTRepository relativeMotherPTRepository;
    private final RegionRefRepository regionRefRepository;
    private final MilitaryStatusRefRepository militaryStatusRefRepository;
    private final SportQualificationRefRepository sportQualificationRefRepository;
    private final EntrantStatusRefRepository entrantStatusRefRepository;
    private final SpecialityRefRepository specialityRefRepository;
    private final ForeignLanguageRefRepository foreignLanguageRefRepository;
    private final EducationalDocumentPTRepository educationalDocumentPTRepository;
    private final EntrantPTRepository entrantPTRepository;
    private final IdentificationInfoPTRepository identificationInfoPTRepository;
    private final ru.esstu.entrant.lk.repositories.reference.EducationalAchievementsRefRepository educationalAchievementsRef;

    public AcceptAnketaService(
            AdmissionInfoRepository admissionInfoRepository,
            AdditionalInformationRepository additionalInformationRepository,
            AccessService accessService,
            BenefitInformationRepository benefitInformationRepository,
            ChangesDateRepository changesDateRepository,
            ContactInformationRepository contactInformationRepository,
            EducationalAchievementsRepository educationalAchievementsRepository,
            EntrantPrivateDataRepository entrantPrivateDataRepository,
            EntrantRepository entrantRepository,
            JobInformationRepository jobInformationRepository,
            ParentsInformationRepository parentsInformationRepository,
            PassportDataRepository passportDataRepository,
            EducationInfoRepository educationInfoRepository,
            AcceptAnketaRepository acceptAnketaRepository,
            PersonPTRepository personPTRepository,
            RelativeFatherPTRepository relativeFatherPTRepository,
            RelativeMotherPTRepository relativeMotherPTRepository,
            RegionRefRepository regionRefRepository,
            ru.esstu.entrant.lk.repositories.reference.EducationalAchievementsRefRepository educationalAchievementsRef,
            MilitaryStatusRefRepository militaryStatusRefRepository,
            SportQualificationRefRepository sportQualificationRefRepository,
            EntrantStatusRefRepository entrantStatusRefRepository,
            SpecialityRefRepository specialityRefRepository,
            ForeignLanguageRefRepository foreignLanguageRefRepository,
            EducationalDocumentPTRepository educationalDocumentPTRepository,
            EntrantPTRepository entrantPTRepository,
            IdentificationInfoPTRepository identificationInfoPTRepository) {
        this.admissionInfoRepository = admissionInfoRepository;
        this.additionalInformationRepository = additionalInformationRepository;
        this.benefitInformationRepository = benefitInformationRepository;
        this.changesDateRepository = changesDateRepository;
        this.contactInformationRepository = contactInformationRepository;
        this.educationalAchievementsRepository = educationalAchievementsRepository;
        this.educationInfoRepository = educationInfoRepository;
        this.entrantRepository = entrantRepository;
        this.jobInformationRepository = jobInformationRepository;
        this.parentsInformationRepository = parentsInformationRepository;
        this.passportDataRepository = passportDataRepository;
        this.entrantPrivateDataRepository = entrantPrivateDataRepository;
        this.accessService = accessService;
        this.acceptAnketaRepository = acceptAnketaRepository;
        this.personPTRepository = personPTRepository;
        this.relativeFatherPTRepository = relativeFatherPTRepository;
        this.relativeMotherPTRepository = relativeMotherPTRepository;
        this.regionRefRepository = regionRefRepository;
        this.educationalAchievementsRef = educationalAchievementsRef;
        this.militaryStatusRefRepository = militaryStatusRefRepository;
        this.sportQualificationRefRepository = sportQualificationRefRepository;
        this.entrantStatusRefRepository = entrantStatusRefRepository;
        this.specialityRefRepository = specialityRefRepository;
        this.foreignLanguageRefRepository = foreignLanguageRefRepository;
        this.educationalDocumentPTRepository = educationalDocumentPTRepository;
        this.entrantPTRepository = entrantPTRepository;
        this.identificationInfoPTRepository = identificationInfoPTRepository;
    }

    @Transactional
    public void AcceptAnketa(final int entrantId, final int moderatorId) {
        accessService.commonAccessCheck(moderatorId);
        try {
            List<AdditionalInformation> additionalInformation = additionalInformationRepository.getAdditionalInformation(entrantId);
            List<AdmissionInfo> admissionInfo = admissionInfoRepository.getAdmissionInfos(entrantId);
            BenefitInformation benefitInformation = benefitInformationRepository.getBenefitInformation(entrantId);
            ChangesDate changesDate = changesDateRepository.getChangesDate(entrantId);
            ContactInformation contactInformation = contactInformationRepository.getContactInformation(entrantId);
            List<EducationalAchievements> educationalAchievements = educationalAchievementsRepository.getEducationalAchievements(entrantId);
            EducationInfo educationInfo = educationInfoRepository.getEducationInfo(entrantId);
            EntrantPrivateData entrantPrivateData = entrantPrivateDataRepository.getEntrantPrivateData(entrantId);
            Entrant entrant = entrantRepository.getEntrant(entrantId);
            JobInformation jobInformation = jobInformationRepository.getJobInformation(entrantId);
            PassportData passportData = passportDataRepository.getPassportData(entrantId);
            ParentsInformation parentsInformation = parentsInformationRepository.getParentsInformation(entrantId);


            Keycloak keycloak = entrantRepository.getKeycloakGuid(entrantId);
            if (jobInformation == null) {
                jobInformation = new JobInformation();
            }
            Person person = personPTRepository.getPerson(keycloak.getKeycloakGuid());

            if (person == null) {
                if (entrantPrivateData.getGender().equals("male"))
                    acceptAnketaRepository.addEntrantPerson(benefitInformation,
                            contactInformation, entrantPrivateData,
                            entrant, jobInformation, entrantRepository.getKeycloakGuid(entrantId),
                            true, IdFactory.getGUID(this));
                else {
                    acceptAnketaRepository.addEntrantPerson(benefitInformation,
                            contactInformation, entrantPrivateData, entrant, jobInformation,
                                entrantRepository.getKeycloakGuid(entrantId), false, IdFactory.getGUID(this));
                }
            } else {
                throw new AlreadyHaveException("?????????? ?????????????? ?????? ????????");
            }
            person = personPTRepository.getPerson(keycloak.getKeycloakGuid());
            String guid = IdFactory.getGUID(this);
            if (additionalInformation.get(1).isCoincides()) {
                acceptAnketaRepository.addAddress(additionalInformation.get(0), changesDate, guid, Integer.parseInt(additionalInformation.get(0).getRegion()));
                acceptAnketaRepository.createAddressPerson(additionalInformation.get(0), person, guid, 1);
                guid = IdFactory.getGUID(this);
                acceptAnketaRepository.addAddress(additionalInformation.get(0), changesDate, guid, Integer.parseInt(additionalInformation.get(0).getRegion()));
                acceptAnketaRepository.createAddressPerson(additionalInformation.get(0), person, guid, 2);
            } else
                for (int i = 0; i < additionalInformation.size(); i++) {
                    if (additionalInformation.get(i).getType().equals("REGISTRATION_ADDRESS")) {
                        guid = IdFactory.getGUID(this);
                        acceptAnketaRepository.addAddress(additionalInformation.get(i), changesDate, guid, Integer.parseInt(additionalInformation.get(i).getRegion()));
                        acceptAnketaRepository.createAddressPerson(additionalInformation.get(i), person, guid, 1);
                    } else {
                        guid = IdFactory.getGUID(this);
                        acceptAnketaRepository.addAddress(additionalInformation.get(i), changesDate, guid, Integer.parseInt(additionalInformation.get(i).getRegion()));
                        acceptAnketaRepository.createAddressPerson(additionalInformation.get(i), person, guid, 2);

                    }
                }
            int militaryStatusId;
            if (entrantPrivateData.getReservist().equals("no")) {
                militaryStatusId = 1;
            } else {
                militaryStatusId = 5;
            }
            Integer sportQualificationId = null;
            if (educationalAchievements != null && educationalAchievements.size() > 0) {
                if (!educationalAchievements.get(0).getCandidateMinimumsPassed().equals("null")) {
                    if (!educationalAchievements.get(0).getCandidateMinimumsPassed().equals("")) {
                        sportQualificationId =
                                Integer.parseInt(educationalAchievements.get(0).getCandidateMinimumsPassed());
                    }
                }
            }
            //int entrantStatus=entrantStatusRefRepository.getOne(entrant.getStatus()).getEntrantStatusId();
            boolean needHostel;
            String tmp = entrantPrivateData.getNeedsHostel();
            if (entrantPrivateData.getNeedsHostel().equals("yes")) {
                needHostel = true;
            } else {
                needHostel = false;
            }
            if (educationInfo.getRegionOfFinished() != null) {
                if (educationInfo.getRegionOfFinished() == 0) {
                    educationInfo.setRegionOfFinished(null);
                }
            }
            if (educationInfo.getDistrictOfFinished() != null) {
                if (educationInfo.getDistrictOfFinished() == 0) {
                    educationInfo.setDistrictOfFinished(null);
                }
            }
            acceptAnketaRepository.addEntrant(person, entrantPrivateData, changesDate, entrant, militaryStatusId, needHostel, sportQualificationId, educationInfo);
            educationInfo.setDocumentOfEducationSerialNumber(educationInfo.getDocumentOfEducationSerialNumber().replaceAll("\\s+", ""));
            int temp = educationInfo.getDocumentOfEducationSerialNumber().length();
            String docSerial = "0";
            String docNumber = educationInfo.getDocumentOfEducationSerialNumber();
            if (temp > 6) {
                docSerial = educationInfo.getDocumentOfEducationSerialNumber().substring(0, 6);
                docNumber = educationInfo.getDocumentOfEducationSerialNumber().substring(6, temp);
            }
            acceptAnketaRepository.addIdentificationInfo(passportData, person);


            int achievementsId = 1;
            if (educationalAchievements != null && educationalAchievements.size() > 0) {
                if (educationalAchievements.get(0).getMedal() != null) {
                    if (educationalAchievements.get(0).getMedal().equals("gold")) {
                        achievementsId = 2;
                    }
                    if (educationalAchievements.get(0).getMedal().equals("silver")) {
                        achievementsId = 3;
                    }
                }
            }
            int end_year = Integer.parseInt(educationInfo.getYearOfFinished());
            //EducationalDocument doc = educationalDocumentPTRepository.getDocument(docSerial,docNumber);

            int education = Integer.parseInt(educationInfo.getEducation());
            Integer documentOfEducation = Integer.parseInt(educationInfo.getDocumentOfEducation());
            acceptAnketaRepository.addEducationalDocument(educationInfo, person, docNumber, docSerial, achievementsId, end_year, education, documentOfEducation);

        /*for(int i=0;i<additionalInformation.size();i++) {
            temp=educationalAchievements.get(i).getDocumentOfOlympiadVictoriesSerialNumber().length();
            docNumber = educationalAchievements.get(i).getDocumentOfOlympiadVictoriesSerialNumber().substring(0,3);
            docSerial = educationalAchievements.get(i).getDocumentOfOlympiadVictoriesSerialNumber().substring(4,temp);
            acceptAnketaRepository.addOlimpiadDocument(person, educationalAchievements.get(i), IdFactory.getGUID(this),docNumber,docSerial);
        }*/

            if (benefitInformation != null) {
                temp = benefitInformation.getDocumentForTheBenefit().length();
                if (benefitInformation.getDocumentForTheBenefit().length() > 5) {
                    docNumber = benefitInformation.getDocumentForTheBenefit().substring(0, 6);
                    docSerial = benefitInformation.getDocumentForTheBenefit().substring(6, temp);
                } else {
                    docNumber = benefitInformation.getDocumentForTheBenefit().substring(0, temp);
                    docSerial = "";
                }
                acceptAnketaRepository.addBenefitDocument(person, benefitInformation, IdFactory.getGUID(this), docNumber, docSerial);
            }
            int foreignLanguageId = 7;
            if (educationInfo.getStudiedLanguage().equals("english")) {
                foreignLanguageId = 1;
            }
            if (educationInfo.getStudiedLanguage().equals("french")) {
                foreignLanguageId = 2;
            }
            if (educationInfo.getStudiedLanguage().equals("german")) {
                foreignLanguageId = 3;
            }
            if (educationInfo.getStudiedLanguage().equals("other") || educationInfo.getStudiedLanguage().equals("spanish")) {
                foreignLanguageId = 6;
            }
            acceptAnketaRepository.addLanguage(foreignLanguageId, person);
            List<Speciality> list = specialityRefRepository.getSpecialities();
            long directionId = 0;
            for (int i = 0; i < admissionInfo.size(); i++) {
                Integer profile = null;
                if (NumberUtils.isDigits(admissionInfo.get(i).getProfile())) {
                    profile = Integer.parseInt(admissionInfo.get(i).getProfile());
                }
                acceptAnketaRepository.addSpeciality(admissionInfo.get(i), person, i + 1, moderatorId, changesDate,
                        IdFactory.getGUID(this), Integer.parseInt(admissionInfo.get(i).getDirection()),
                        Integer.parseInt(admissionInfo.get(i).getAdmittanceCategory()),
                        profile);
            }
            guid = IdFactory.getGUID(this);
            acceptAnketaRepository.addFatherPerson(person, parentsInformation, "mail", guid);
            acceptAnketaRepository.addRelativeFather(parentsInformation, person, guid);
            guid = IdFactory.getGUID(this);
            acceptAnketaRepository.addMotherPerson(person, parentsInformation, "mail", guid);
            acceptAnketaRepository.addRelativeMother(parentsInformation, person, guid);
        } catch (Exception e) {
            throw new AlreadyHaveException(e.getMessage());
        }
    }
}
