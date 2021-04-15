package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.dto.PassportDataDto;
import ru.esstu.entrant.lk.domain.vo.PassportData;

@Mapper
public interface PassportDataRepository {
    @Select("SELECT * FROM passport_data WHERE id = #{id}")
    PassportData getPassportData(@Param("id") String id);
    @Insert("INSERT INTO parents_information VALUES('#{passportData.id}','#{passportData.serial_number}','#{passportData.place_of_issue},'#{passportData.code_of_subdivision}','#{passportData.date_of_issue}'')")
    PassportDataDto postPassportData(@Param("entity") PassportData passportData);
}
