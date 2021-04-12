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
    @Insert("INSERT INTO job_information VALUES('#{id}','#{father_mobile_number}','#{father_name}','#{father_second_name}','#{father_patronymic}','#{place_of_father_job}','#{mother_mobile_number}','#{mother_name}','#{mother_second_name}','#{mother_patronymic}','#{place_of_mother_job}','#{additional_phone_number}')")
    ParentsInformationDto postParentsInformation(@Param("id") String id,@Param("father_mobile_number") String father_mobile_number,@Param("father_name") String father_name,@Param("father_second_name") String father_second_name,@Param("father_patronymic") String father_patronymic,@Param("place_of_father_job") String place_of_father_job,@Param("mother_mobile_number") String mother_mobile_number,@Param("mother_name") String mother_name,@Param("mother_second_name") String mother_second_name,@Param("mother_patronymic") String mother_patronymic,@Param("place_of_mother_job") String place_of_mother_job,@Param("additional_phone_number") String additional_phone_number);
}