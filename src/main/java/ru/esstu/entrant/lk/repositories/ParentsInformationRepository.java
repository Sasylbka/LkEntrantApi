package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.dto.ParentsInformationDto;
import ru.esstu.entrant.lk.domain.vo.ParentsInformation;

@Mapper
public interface ParentsInformationRepository {
    @Select("SELECT * FROM parents_information WHERE id = #{id}")
    ParentsInformation getParentsInformation(@Param("id") String id);
    @Insert("INSERT INTO parents_information VALUES('#{parentsInformation.id}','#{parentsInformation.father_mobile_number}','#{parentsInformation.father_name}','#{parentsInformation.father_second_name}','#{parentsInformation.father_patronymic}','#{parentsInformation.place_of_father_job}','#{parentsInformation.mother_mobile_number}','#{parentsInformation.mother_name}','#{parentsInformation.mother_second_name}','#{parentsInformation.mother_patronymic}','#{parentsInformation.place_of_mother_job}','#{parentsInformation.additional_phone_number}')")
    ParentsInformationDto postParentsInformation(@Param("entity") ParentsInformation parentsInformation);
}