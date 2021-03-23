package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.PassportData;

@Mapper
public interface PassportDataRepository {
    @Select("SELECT * FROM passport_data WHERE id = #{id}")
    PassportData getPassportData(@Param("id") String id);
}
