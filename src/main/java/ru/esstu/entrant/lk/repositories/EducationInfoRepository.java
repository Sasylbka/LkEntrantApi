package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.EducationInfoDto;
import ru.esstu.entrant.lk.domain.vo.EducationInfo;

@Mapper
public interface EducationInfoRepository {
    @Select("SELECT * FROM education_info WHERE id = #{id}")
    EducationInfo getEducationInfo(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO education_info(entrantId, education, year_of_finished, document_of_education, document_of_education_serial_number," +
            "place_of_finished, date_of_finished, studied_language, year_of_finished, if_choosen_level_of_education_first)" +
            " VALUES(#{educationInfo.entrantId},#{educationInfo.education},#{educationInfo.year_of_finished}," +
            "#{educationInfo.document_of_education},#{educationInfo.document_of_education_serial_number}," +
            "#{educationInfo.place_of_finished},#{educationInfo.date_of_finished},#{educationInfo.studied_language}," +
            "#{educationInfo.year_of_finished},#{educationInfo.if_choosen_level_of_education_first})")
    long save(@Param("educationInfo") EducationInfo educationInfo);
}
