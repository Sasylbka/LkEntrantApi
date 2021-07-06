package ru.esstu.entrant.lk.repositories.PublicTables;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.PublicTables.EntrantPerson;
@Mapper
public interface EntrantPersonPTRepository {
    @Select("SELECT public.person.name," +
            "public.person.surname," +
            "public.person.patronymic,public.entrant.male," +
            "public.person.birthdate," +
            "public.person.snils, " +
            "public.person.birth_city," +
            "public.person.birth_region " +
            "From public.person where activate_code=#{person_id}")
    EntrantPerson getEntrantPerson(@Param("person_id")String person_id);
}
