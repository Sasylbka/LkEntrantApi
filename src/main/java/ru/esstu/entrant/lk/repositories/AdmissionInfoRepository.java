package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;

@Mapper
public interface AdmissionInfoRepository {
    @Select("SELECT * FROM admission_info WHERE id = #{id}")
    AdmissionInfo getAdmissionInfo(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO admission_info(entrantId, level_of_education, first_direction, second_direction, third_direction) " +
            "VALUES(#{admissionInfo.entrantId},#{admissionInfo.level_of_education},#{admissionInfo.first_direction}" +
            ",#{admissionInfo.second_direction},#{admissionInfo.third_direction})")
    long save(@Param("admissionInfo") AdmissionInfo admissionInfo);

}