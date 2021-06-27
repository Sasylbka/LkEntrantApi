package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ru.esstu.entrant.lk.domain.vo.*;
import ru.esstu.entrant.lk.domain.vo.Additionals.Keycloak;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;
import ru.esstu.entrant.lk.domain.vo.PublicTables.RelativeFather;
import ru.esstu.entrant.lk.domain.vo.PublicTables.RelativeMother;

@Mapper
public interface AcceptAnketaRepository {
    @Insert("Insert into public.person(person_id, surname, name, patronymic, male, " +
            "telephone, mail, birthdate, activate_id, enabled, " +
            "external, username, password, birth_city, birth_region, " +
            "snils) " +
            "Values (#{guid},#{entrantPrivateData.familyName}, " +
            "#{entrantPrivateData.name}, #{entrantPrivateData.patronymic}, #{male}," +
            " #{contactInformation.mobileNumber}, #{contactInformation.email}, #{entrantPrivateData.dateOfBirth}," +
            "#{keycloak.keycloakGuid}, true, true, #{entrant.login}, #{entrant.password}, " +
            "#{entrantPrivateData.cityOfBirth},#{entrantPrivateData.regionOfBirth}," +
            " #{entrantPrivateData.snills})")
    long addEntrantPerson(@Param("benefitInformation")BenefitInformation benefitInformation,
                   @Param("contactInformation") ContactInformation contactInformation,
                   @Param("entrantPrivateData") EntrantPrivateData entrantPrivateData,
                   @Param("entrant") Entrant entrant,
                   @Param("jobInformation") JobInformation jobInformation,
                   @Param("keycloak") Keycloak keycloak,
                          @Param("male")boolean male,
                          @Param("guid") String guid);
    @Insert("INSERT INTO public.address(" +
            " addr_id,city, street, index, region_id, " +
            "building_num, flat_num, creation_time)" +
            "VALUES (#{guid},#{additionalInformation.city},#{additionalInformation.street}, " +
            "#{additionalInformation.index}, #{regionId}," +
            " #{additionalInformation.numberOfBuilding}, #{additionalInformation.numberOfApartments}, " +
            " #{changesDate.dateOfCreation})")
    long addAddress(@Param("additionalInformation")AdditionalInformation additionalInformation,
                   @Param("changesDate") ChangesDate changesDate,@Param("guid") String guid,@Param("regionId") int regionId);
    @Insert("INSERT INTO public.person_address_mtm(" +
            "person_id, addr_id, address_type_id)" +
            "VALUES  (#{person.personId},#{guid},#{type})")
    long createAddressPerson(@Param("additionalInformation")AdditionalInformation additionalInformation,
                             @Param("person")Person person,
                             @Param("guid") String guid,
                             @Param("type")int type);
    @Insert("INSERT INTO public.identification_info(" +
            "person_id, doc_number, release_date, releasing_org_name, doc_series, department_code,doc_type_id) " +
            "VALUES (#{person.personId}, #{passportData.number}, #{passportData.dateOfIssue}, " +
            "#{passportData.placeOfIssue}, #{passportData.series}, " +
            "#{passportData.codeOfSubdivision}, 4)")
    long addIdentificationInfo(@Param("passportData")PassportData passportData, @Param("person")Person person);
    @Insert("INSERT INTO public.educational_document(" +
            "entrant_id, edu_inst_name, doc_series, doc_number, " +
            "doc_date,  achievement_id, end_year,edu_inst_type_id,edu_doc_type_id)" +
            "VALUES (#{person.personId},#{educationInfo.placeOfFinished} ,#{docSerial} " +
            ", #{docNumber}, #{educationInfo.dateOfFinished},  #{achievementsId}," +
            "#{endDate}, #{education},#{documentOfEducation})")
    long addEducationalDocument(@Param("educationInfo")EducationInfo educationInfo, @Param("person") Person person,
                                @Param("educationalAchievements") EducationalAchievements educationalAchievements,
                                @Param("docNumber")String docNumber,@Param("docSerial")String docSerial,
                                @Param("achievementsId") int achievementsId,@Param("endDate") int endDate,
                                @Param("education")int education,
                                @Param("documentOfEducation")int documentOfEducation);
    @Insert("Insert into public.entrant_doc (doc_id, entrant_id, " +
            "doc_series, doc_number, doc_date, doc_organization) " +
            "VALUES (doc_id=#{guid},entrant_id=#{person.personId}," +
            "doc_series=#{docSerial.documentOfOlympiadVictoriesSerialNumber}, doc_number=#{docNumber}, " +
            "doc_date=#{educationalAchievements.dataOfIssued},doc_organization=#{educationalAchievements.issuedBy}")
    long addOlimpiadDocument(@Param("person")Person person,
                             @Param("educationalAchievements") EducationalAchievements educationalAchievements,
                             @Param("guid") String guid,@Param("docNumber")String docNumber,
                             @Param("docSerial")String docSerial);
    @Insert("Insert into public.entrant_doc (doc_id, entrant_id," +
            "doc_series, doc_number, doc_date, doc_organization,doc_type_id) " +
            "VALUES (#{guid}, #{person.personId},  " +
            "#{docSerial}, " +
            "#{docNumber}, #{benefitInformation.dataOfIssued}, #{benefitInformation.issuedBy},#{benefitInformation.reasonForTheBenefit})")
    long addBenefitDocument(@Param("person")Person person,
                            @Param("benefitInformation") BenefitInformation benefitInformation,
                            @Param("guid") String guid,
                            @Param("docNumber")String docNumber,
                            @Param("docSerial")String docSerial);
    @Insert("Insert into public.entrant_lang_mtm (lang_id,person_id) " +
            "Values(#{foreignLanguageId},#{person.personId})")
    long addLanguage(@Param("foreignLanguageId")int foreignLanguageId,@Param("person")Person person);
    @Insert("Insert into public.entrance_info (entrance_info_id, " +
            "entrant_id, spec_id,registered_on ,taken_docs_away, " +
            "prefer_number,edu_manager_id,passed_preparatory_course,admittance_category_id) " +
            "VALUES (#{guid}, #{person.personId}, " +
            "#{directionId}, #{changesDate.dateOfCreation}, " +
            "false,#{prefer_number}, " +
            "#{moderatorId},false,#{admittanceCategory})")
    long addSpeciality(@Param("admissionInfo") AdmissionInfo admissionInfo,
                       @Param("person")Person person,
                       @Param("prefer_number")int prefer_number,
                       @Param("moderatorId")int moderatorId,
                       @Param("changesDate") ChangesDate changesDate,
                       @Param("guid") String guid,
                       @Param("directionId")long directionId,
                       @Param("admittanceCategory")int admittanceCategory);
    @Insert("Insert into public.relative (realtive_id,labour_place,grade_id,entrant_id) " +
            "Values(#{guid},#{parentsInformation.placeOfFatherJob}," +
            "5,#{person.personId})")
    long addRelativeFather(@Param("parentsInformation") ParentsInformation parentsInformation,
                           @Param("person") Person person,
                           @Param("guid")String guid);
    @Insert("Insert into public.person (person_id, surname, name, patronymic, male, telephone, " +
            "mail,  enabled, external) " +
            "VALUES (#{guid}, #{parentsInformation.fatherSecondName},#{parentsInformation.fatherName}, " +
                "#{parentsInformation.fatherPatronymic}, true, #{parentsInformation.fatherMobileNumber}, #{mail}, false, false)")
    long addFatherPerson(@Param("person") Person person,
                         @Param("parentsInformation") ParentsInformation parentsInformation,
                         @Param("mail") String mail,
                         @Param("guid") String guid);
    @Insert("Insert into public.relative (realtive_id,labour_place,grade_id,entrant_id) " +
            "Values(#{guid},#{parentsInformation.placeOfMotherJob}," +
            "6,#{person.personId})")
    long addRelativeMother(@Param("parentsInformation") ParentsInformation parentsInformation,
                           @Param("person") Person person,
                           @Param("guid")String guid);
    @Insert("Insert into public.person (person_id, surname, name, patronymic, male, telephone, " +
            "mail,  enabled, external) " +
            "VALUES (#{guid}, #{parentsInformation.motherSecondName}, #{parentsInformation.motherName}, " +
            "#{parentsInformation.motherPatronymic}, false, #{parentsInformation.motherMobileNumber}, #{mail}, false, false)")
    long addMotherPerson(@Param("person") Person person,
                         @Param("parentsInformation") ParentsInformation parentsInformation,
                         @Param("mail") String mail,
                         @Param("guid")String guid);
    @Insert("Insert into public.entrant (entrant_id,military_status_id,nat_id,cit_id," +
            "need_hostel,statement_date,entrant_status_id,username,sport_qualification_id) " +
            "Values(#{person.personId},#{militaryStatusId},0,1," +
            "#{needHostel},#{changesDate.dateOfCreation},3," +
            "#{entrant.login},#{sportQualificationId})")
    long addEntrant(@Param("person")Person person,
                    @Param("entrantPrivateData") EntrantPrivateData entrantPrivateData,
                    @Param("educationAchievements")EducationalAchievements educationalAchievements,
                    @Param("changesDate")ChangesDate changesDate,
                    @Param("entrant")Entrant entrant,
                    @Param("militaryStatusId")int militaryStatusId,
                    @Param("needHostel") boolean needHostel,
                    @Param("sportQualificationId")Integer sportQualificationId);

}


