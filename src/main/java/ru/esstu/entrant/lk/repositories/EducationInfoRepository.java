package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.dto.EducationInfoDto;
import ru.esstu.entrant.lk.domain.vo.EducationInfo;

@Mapper
public interface EducationInfoRepository {
    @Select("SELECT * FROM education_info WHERE id = #{id}")
    EducationInfo getEducationInfo(@Param("id") String id);
    @Insert("INSERT INTO education_info VALUES('#{educationInfo.id}','#{educationInfo.education}','#{educationInfo.year_of_finished}','#{educationInfo.document_of_education}','#{educationInfo.document_of_education_serial_number}','#{educationInfo.place_of_finished}','#{educationInfo.date_of_finished}','#{educationInfo.studied_language}','#{educationInfo.year_of_finished}','#{educationInfo.if_choosen_level_of_education_first}')")
    EducationInfoDto postEducationInfo(@Param("entity") EducationInfo educationInfo);
}
