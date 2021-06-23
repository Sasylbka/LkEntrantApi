package ru.esstu.entrant.lk.repositories.PublicTables;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Entrant;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;

@Mapper
public interface EntrantPTRepository {
    @Select("SELECT entrant_id From public.entrant where entrant_id=#{person_id}")
    Entrant getEntrant(@Param("person_id")String person_id);
}
