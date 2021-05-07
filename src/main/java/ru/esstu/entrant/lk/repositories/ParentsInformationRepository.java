package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.ParentsInformationDto;
import ru.esstu.entrant.lk.domain.vo.ParentsInformation;

@Mapper
public interface ParentsInformationRepository {
    @Select("SELECT * FROM parents_information WHERE id = #{id}")
    ParentsInformation getParentsInformation(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO parents_information(entrant_id, father_mobile_number, father_name, father_second_name, father_patronymic, place_of_father_job," +
            "mother_mobile_number, mother_name, mother_second_name, mother_patronymic, place_of_mother_job, additional_phone_number) " +
            "VALUES(#{parentsInformation.entrantId},#{parentsInformation.father_mobile_number},#{parentsInformation.father_name}," +
            "#{parentsInformation.father_second_name},#{parentsInformation.father_patronymic},#{parentsInformation.place_of_father_job}," +
            "#{parentsInformation.mother_mobile_number},#{parentsInformation.mother_name},#{parentsInformation.mother_second_name}," +
            "#{parentsInformation.mother_patronymic},#{parentsInformation.place_of_mother_job},#{parentsInformation.additional_phone_number})")
    long save(@Param("parentsInformation") ParentsInformation parentsInformation);
}