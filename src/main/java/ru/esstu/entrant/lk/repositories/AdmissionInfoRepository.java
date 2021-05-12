package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;

@Mapper
public interface AdmissionInfoRepository {
    @Select("SELECT * FROM admission_info WHERE entrant_id=#{id}")
    AdmissionInfo getAdmissionInfo(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO admission_info(entrant_id, level_of_education, first_direction, second_direction, third_direction) " +
            "VALUES(#{admissionInfo.entrantId},#{admissionInfo.levelOfEducation},#{admissionInfo.firstDirection}" +
            ",#{admissionInfo.secondDirection},#{admissionInfo.thirdDirection})")
    long save(@Param("admissionInfo") AdmissionInfo admissionInfo);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE admission_info SET level_of_education=#{admissionInfo.levelOfEducation}, first_direction=#{admissionInfo.firstDirection}, " +
            "second_direction=#{admissionInfo.secondDirection}, third_direction=#{admissionInfo.thirdDirection} WHERE entrant_id=#{admissionInfo.entrantId}")
    long update(@Param("admissionInfo") AdmissionInfo admissionInfo);
}