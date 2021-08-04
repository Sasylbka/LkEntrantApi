package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.PassportDataDto;
import ru.esstu.entrant.lk.domain.vo.PassportData;

@Mapper
public interface PassportDataRepository {
    @Select("SELECT * FROM passport_data WHERE entrant_id = #{id}")
    PassportData getPassportData(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO passport_data(entrant_id, series,number, place_of_issue, code_of_subdivision, date_of_issue,foreigner) " +
            "VALUES(#{passportData.entrantId},#{passportData.series},#{passportData.number},#{passportData.placeOfIssue}," +
            "#{passportData.codeOfSubdivision},#{passportData.dateOfIssue},#{passportData.foreigner})")
    long save(@Param("passportData") PassportData passportData);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE passport_data SET " +
            "series=#{passportData.series},number=#{passportData.number}, place_of_issue=#{passportData.placeOfIssue}, " +
            "code_of_subdivision=#{passportData.codeOfSubdivision}, date_of_issue=#{passportData.dateOfIssue}, foreigner=#{passportData.foreigner} WHERE entrant_id=#{passportData.entrantId}")
    long update(@Param("passportData") PassportData passportData);
}
