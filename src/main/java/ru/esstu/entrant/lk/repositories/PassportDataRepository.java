package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.PassportDataDto;
import ru.esstu.entrant.lk.domain.vo.PassportData;

@Mapper
public interface PassportDataRepository {
    @Select("SELECT * FROM passport_data WHERE id = #{id}")
    PassportData getPassportData(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO parents_information(entrantId, serial_number, place_of_issue, code_of_subdivision, date_of_issue) " +
            "VALUES(#{passportData.entrantId},#{passportData.serial_number},#{passportData.place_of_issue}," +
            "#{passportData.code_of_subdivision},#{passportData.date_of_issue})")
    long save(@Param("passportData") PassportData passportData);
}
