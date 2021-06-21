package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.ParentsInformationDto;
import ru.esstu.entrant.lk.domain.vo.ParentsInformation;

@Mapper
public interface ParentsInformationRepository {
    @Select("SELECT * FROM parents_information WHERE entrant_id = #{id}")
    ParentsInformation getParentsInformation(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO parents_information(entrant_id, father_mobile_number, father_name, father_second_name, father_patronymic, place_of_father_job," +
            "father_email,mother_mobile_number, mother_name, mother_second_name, mother_patronymic, place_of_mother_job,mother_email, additional_phone_number) " +
            "VALUES(#{parentsInformation.entrantId},#{parentsInformation.fatherMobileNumber},#{parentsInformation.fatherName}," +
            "#{parentsInformation.fatherSecondName},#{parentsInformation.fatherPatronymic},#{parentsInformation.placeOfFatherJob},#{parentsInformation.fatherEmail}," +
            "#{parentsInformation.motherMobileNumber},#{parentsInformation.motherName},#{parentsInformation.motherSecondName}," +
            "#{parentsInformation.motherPatronymic},#{parentsInformation.placeOfMotherJob},#{parentsInformation.motherEmail},#{parentsInformation.additionalPhoneNumber})")
    long save(@Param("parentsInformation") ParentsInformation parentsInformation);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE parents_information SET " +
            "father_mobile_number=#{parentsInformation.fatherMobileNumber}, father_name=#{parentsInformation.fatherName}, " +
            "father_second_name=#{parentsInformation.fatherSecondName}, father_patronymic=#{parentsInformation.fatherPatronymic}, " +
            "place_of_father_job=#{parentsInformation.placeOfFatherJob}, " +
            "mother_mobile_number=#{parentsInformation.motherMobileNumber}, mother_name=#{parentsInformation.motherName}, " +
            "mother_second_name=#{parentsInformation.motherSecondName}, mother_patronymic=#{parentsInformation.motherPatronymic}, " +
            "place_of_mother_job=#{parentsInformation.placeOfMotherJob}, additional_phone_number=#{parentsInformation.additionalPhoneNumber},mother_email=#{parentsInformation.motherEmail}," +
            "father_email=#{parentsInformation.fatherEmail}" +
            "WHERE entrant_id=#{parentsInformation.entrantId}")
    long update(@Param("parentsInformation") ParentsInformation parentsInformation);
}