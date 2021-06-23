package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.mappers.*;
import ru.esstu.entrant.lk.domain.vo.*;
import ru.esstu.entrant.lk.domain.vo.Additionals.Keycloak;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;
import ru.esstu.entrant.lk.domain.vo.PublicTables.RelativeFather;
import ru.esstu.entrant.lk.domain.vo.PublicTables.RelativeMother;
import ru.esstu.entrant.lk.domain.vo.reference.EntrantStatus;
import ru.esstu.entrant.lk.domain.vo.reference.MilitaryStatus;
import ru.esstu.entrant.lk.domain.vo.reference.Speciality;
import ru.esstu.entrant.lk.repositories.*;
import ru.esstu.entrant.lk.repositories.PublicTables.PersonPTRepository;
import ru.esstu.entrant.lk.repositories.PublicTables.RelativeFatherPTRepository;
import ru.esstu.entrant.lk.repositories.PublicTables.RelativeMotherPTRepository;
import ru.esstu.entrant.lk.repositories.AcceptAnketaRepository;
import ru.esstu.entrant.lk.repositories.reference.*;
import ru.esstu.entrant.lk.utils.IdFactory;

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
            ForeignLanguageRefRepository foreignLanguageRefRepository){
        this.admissionInfoRepository=admissionInfoRepository;
        this.additionalInformationRepository=additionalInformationRepository;
        this.benefitInformationRepository=benefitInformationRepository;
        this.changesDateRepository=changesDateRepository;
        this.contactInformationRepository=contactInformationRepository;
        this.educationalAchievementsRepository=educationalAchievementsRepository;
        this.educationInfoRepository=educationInfoRepository;
        this.entrantRepository=entrantRepository;
        this.jobInformationRepository=jobInformationRepository;
        this.parentsInformationRepository=parentsInformationRepository;
        this.passportDataRepository=passportDataRepository;
        this.entrantPrivateDataRepository=entrantPrivateDataRepository;
        this.accessService=accessService;
        this.acceptAnketaRepository=acceptAnketaRepository;
        this.personPTRepository=personPTRepository;
        this.relativeFatherPTRepository=relativeFatherPTRepository;
        this.relativeMotherPTRepository=relativeMotherPTRepository;
        this.regionRefRepository=regionRefRepository;
        this.educationalAchievementsRef=educationalAchievementsRef;
        this.militaryStatusRefRepository=militaryStatusRefRepository;
        this.sportQualificationRefRepository=sportQualificationRefRepository;
        this.entrantStatusRefRepository=entrantStatusRefRepository;
        this.specialityRefRepository=specialityRefRepository;
        this.foreignLanguageRefRepository=foreignLanguageRefRepository;
    }
    public void AcceptAnketa(final int entrantId, final int moderatorId){
        //accessService.commonAccessCheck(moderatorId);
        List<AdditionalInformation> additionalInformation=additionalInformationRepository.getAdditionalInformation(entrantId);
        List<AdmissionInfo> admissionInfo = admissionInfoRepository.getAdmissionInfos(entrantId);
        BenefitInformation benefitInformation=benefitInformationRepository.getBenefitInformation(entrantId);
        ChangesDate changesDate=changesDateRepository.getChangesDate(entrantId);
        ContactInformation contactInformation=contactInformationRepository.getContactInformation(entrantId);
        List<EducationalAchievements> educationalAchievements=educationalAchievementsRepository.getEducationalAchievements(entrantId);
        EducationInfo educationInfo = educationInfoRepository.getEducationInfo(entrantId);
        EntrantPrivateData entrantPrivateData=entrantPrivateDataRepository.getEntrantPrivateData(entrantId);
        Entrant entrant=entrantRepository.getEntrant(entrantId);
        JobInformation jobInformation=jobInformationRepository.getJobInformation(entrantId);
        PassportData passportData= passportDataRepository.getPassportData(entrantId);
        ParentsInformation parentsInformation=parentsInformationRepository.getParentsInformation(entrantId);


        Keycloak keycloak =entrantRepository.getKeycloakGuid(entrantId);
        if(jobInformation==null){
            jobInformation=new JobInformation();
        }
        if(entrantPrivateData.getGender()=="male")
            acceptAnketaRepository.addEntrantPerson(benefitInformation,contactInformation,entrantPrivateData,entrant,jobInformation,entrantRepository.getKeycloakGuid(entrantId),true,IdFactory.getGUID(this));
        else{
            acceptAnketaRepository.addEntrantPerson(benefitInformation,contactInformation,entrantPrivateData,entrant,jobInformation,entrantRepository.getKeycloakGuid(entrantId),false,IdFactory.getGUID(this));
        }
        Person person=personPTRepository.getPerson(keycloak.getKeycloakGuid());
        String guid = IdFactory.getGUID(this);
        if(additionalInformation.get(0).isCoincides()){
            int regionId= regionRefRepository.getOne(additionalInformation.get(0).getRegion()).getRegionId();
            acceptAnketaRepository.addAddress(additionalInformation.get(0),changesDate,guid,regionRefRepository.getOne(additionalInformation.get(0).getRegion()).getRegionId());
            acceptAnketaRepository.createAddressPerson(additionalInformation.get(0),person,guid,1);
            guid = IdFactory.getGUID(this);
            acceptAnketaRepository.addAddress(additionalInformation.get(0),changesDate,guid,regionRefRepository.getOne(additionalInformation.get(0).getRegion()).getRegionId());
            acceptAnketaRepository.createAddressPerson(additionalInformation.get(0),person,guid,2);
        }
        else
        for(int i =0;i<additionalInformation.size();i++){
            if(additionalInformation.get(i).getType()=="registration"){
                guid = IdFactory.getGUID(this);
                acceptAnketaRepository.addAddress(additionalInformation.get(i),changesDate,guid,regionRefRepository.getOne(additionalInformation.get(i).getRegion()).getRegionId());
                acceptAnketaRepository.createAddressPerson(additionalInformation.get(i),person,guid,1);
            }
            else {
                guid = IdFactory.getGUID(this);
                acceptAnketaRepository.addAddress(additionalInformation.get(i),changesDate,guid,regionRefRepository.getOne(additionalInformation.get(i).getRegion()).getRegionId());
                acceptAnketaRepository.createAddressPerson(additionalInformation.get(i),person,guid,2);

            }
        }
        int militaryStatusId=militaryStatusRefRepository.getOne(entrantPrivateData.getReservist()).getMilitaryStatusId();
        int sportQualificationId=sportQualificationRefRepository.getOne(educationalAchievements.get(0).getCandidateMinimumsPassed()).getSportQualificationId();
        int entrantStatus=entrantStatusRefRepository.getOne(entrant.getStatus()).getEntrantStatusId();
        boolean needHostel;
        String tmp = entrantPrivateData.getNeedsHostel();
        if(entrantPrivateData.getNeedsHostel().equals("yes")){
            needHostel=true;
        }
        else{
            needHostel=false;
        }
        acceptAnketaRepository.addEntrant(person,entrantPrivateData,educationalAchievements.get(0),changesDate,entrant,militaryStatusId,sportQualificationId,needHostel,entrantStatus);
        int temp = educationInfo.getDocumentOfEducationSerialNumber().length();
        String docNumber= educationInfo.getDocumentOfEducationSerialNumber().substring(0,3);
        String docSerial= educationInfo.getDocumentOfEducationSerialNumber().substring(4,temp);
        acceptAnketaRepository.addIdentificationInfo(passportData,person);
        int achievementsId=educationalAchievementsRef.getOne(educationalAchievements.get(0).getMedal()).getAchievementId();
        int end_year=Integer.parseInt(educationInfo.getYearOfFinished());
        acceptAnketaRepository.addEducationalDocument(educationInfo,person,educationalAchievements.get(0),docNumber,docSerial,achievementsId,end_year);
        for(int i=0;i<additionalInformation.size();i++) {
            temp=educationalAchievements.get(i).getDocumentOfOlympiadVictoriesSerialNumber().length();
            docNumber = educationalAchievements.get(i).getDocumentOfOlympiadVictoriesSerialNumber().substring(0,3);
            docSerial = educationalAchievements.get(i).getDocumentOfOlympiadVictoriesSerialNumber().substring(4,temp);
            acceptAnketaRepository.addOlimpiadDocument(person, educationalAchievements.get(i), IdFactory.getGUID(this),docNumber,docSerial);
        }
        if(benefitInformation!=null){
            docNumber = benefitInformation.getDocumentForTheBenefit().substring(0,3);
            docSerial = benefitInformation.getDocumentForTheBenefit().substring(4,temp);
            acceptAnketaRepository.addBenefitDocument(person,benefitInformation,IdFactory.getGUID(this),docNumber,docSerial);
        }
        int foreignLanguageId=foreignLanguageRefRepository.getOne(educationInfo.getStudiedLanguage()).getLangId();
        acceptAnketaRepository.addLanguage(foreignLanguageId,person);
        List<Speciality> list=specialityRefRepository.getSpecialities();
        long directionId=0;
        for(int i=0;i<admissionInfo.size();i++){
            for(int j=0;j< list.size();j++){
                if(list.get(j).getSpecialityName().equals(admissionInfo.get(i).getDirection())){
                    directionId= list.get(j).getSpecId();
                    break;
                }
            }
            acceptAnketaRepository.addSpeciality(admissionInfo.get(i),person,i,moderatorId,changesDate,IdFactory.getGUID(this),directionId);
        }
        guid =IdFactory.getGUID(this);
        acceptAnketaRepository.addFatherPerson(person,parentsInformation,"mail",guid);
        acceptAnketaRepository.addRelativeFather(parentsInformation,person,guid);
        guid =IdFactory.getGUID(this);
        acceptAnketaRepository.addMotherPerson(person,parentsInformation,"mail",guid);
        acceptAnketaRepository.addRelativeMother(parentsInformation,person,guid);
    }
}
