package ru.esstu.entrant.lk.repositories.PublicTables;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;

@Mapper
public interface PersonPTRepository {
    @Select("SELECT person_id From public.person where activate_id=#{activate_id}")
    Person getPerson(@Param("activate_id")String activate_id);
}
