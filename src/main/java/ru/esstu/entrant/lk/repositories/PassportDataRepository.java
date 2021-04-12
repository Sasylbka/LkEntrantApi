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
    @Insert("INSERT INTO job_information VALUES('#{id}','#{serial_number}','#{place_of_issue},'#{code_of_subdivision}','#{date_of_issue}'')")
    PassportDataDto postPassportData(@Param("id") String id, @Param("serial_number") String serial_number, @Param("place_of_issue") String place_of_issue, @Param("code_of_subdivision") String code_of_subdivision, @Param("date_of_issue") String date_of_issue);
}
