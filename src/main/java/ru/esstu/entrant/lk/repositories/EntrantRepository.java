package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.Entrant;

@Mapper
public interface EntrantRepository {
    @Select("SELECT * FROM entrant WHERE id = #{id}")
    Entrant getEntrant(@Param("id") String id);
}
