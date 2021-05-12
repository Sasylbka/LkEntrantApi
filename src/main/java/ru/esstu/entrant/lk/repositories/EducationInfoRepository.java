package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.EducationInfoDto;
import ru.esstu.entrant.lk.domain.vo.EducationInfo;

@Mapper
public interface EducationInfoRepository {
    @Select("SELECT * FROM education_info WHERE entrant_id = #{id}")
    EducationInfo getEducationInfo(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO education_info(entrant_id, education, year_of_finished, document_of_education, document_of_education_serial_number," +
            "place_of_finished, date_of_finished, studied_language, year_of_finished, if_choosen_level_of_education_first)" +
            " VALUES(#{educationInfo.entrantId},#{educationInfo.education},#{educationInfo.yearOfFinished}," +
            "#{educationInfo.documentOfEducation},#{educationInfo.documentOfEducationSerialNumber}," +
            "#{educationInfo.placeOfFinished},#{educationInfo.dateOfFinished},#{educationInfo.studiedLanguage}," +
            "#{educationInfo.yearOfFinished},#{educationInfo.ifChoosenLevelOfEducationFirst})")
    long save(@Param("educationInfo") EducationInfo educationInfo);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE education_info SET " +
            "education=#{educationInfo.education}, year_of_finished=#{educationInfo.yearOfFinished}, " +
            "document_of_education=#{educationInfo.documentOfEducation}, document_of_education_serial_number=#{educationInfo.documentOfEducationSerialNumber}, " +
            "place_of_finished=#{educationInfo.placeOfFinished}, date_of_finished=#{educationInfo.dateOfFinished}, " +
            "studied_language=#{educationInfo.studiedLanguage}, year_of_finished=#{educationInfo.yearOfFinished}, " +
            "if_choosen_level_of_education_first=#{educationInfo.ifChoosenLevelOfEducationFirst} WHERE entrant_id=#{educationInfo.entrantId}")
    long update(@Param("educationInfo") EducationInfo educationInfo);
}
