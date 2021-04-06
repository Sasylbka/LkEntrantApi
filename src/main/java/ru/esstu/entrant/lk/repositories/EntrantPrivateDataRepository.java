package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;

@Mapper
public interface EntrantPrivateDataRepository {
    @Select("SELECT * FROM entrant_private_data WHERE id = #{id}")
    EntrantPrivateData getEntrantPrivateData(@Param("id") String id);
}
