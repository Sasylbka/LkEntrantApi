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
    @Insert("INSERT INTO job_information VALUES('#{id}','#{education}','#{year_of_finished}','#{document_of_education}','#{document_of_education_serial_number}','#{place_of_finished}','#{date_of_finished}','#{studied_language}','#{year_of_finished}','#{if_choosen_level_of_education_first}')")
    EducationInfoDto postEducationInfo(@Param("id") String id, @Param("education") String education, @Param("year_of_finished") String year_of_finished, @Param("document_of_education") String document_of_education, @Param("document_of_education_serial_number") String document_of_education_serial_number, @Param("place_of_finished") String place_of_finished, @Param("date_of_finished") String date_of_finished, @Param("studied_language") String studied_language, @Param("if_choosen_level_of_education_first") String if_choosen_level_of_education_first);
}
