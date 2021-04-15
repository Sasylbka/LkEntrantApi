package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;

@Mapper
public interface AdmissionInfoRepository {
    @Select("SELECT * FROM admission_info WHERE id = #{id}")
    AdmissionInfo getAdmissionInfo(@Param("id") String id);
    @Insert("INSERT INTO admission_info VALUES('#{id}','#{level_of_education}','#{first_direction}','#{second_direction}','#{third_direction}')")
    AdmissionInfoDto postAdmissionInfo(@RequestBody AdmissionInfo admissionInfo);

}