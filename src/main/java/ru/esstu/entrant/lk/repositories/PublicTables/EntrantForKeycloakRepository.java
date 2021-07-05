package ru.esstu.entrant.lk.repositories.PublicTables;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.esstu.entrant.lk.domain.vo.PublicTables.EntrantForKeycloak;

import java.util.List;

@Mapper
public interface EntrantForKeycloakRepository {
    @Select("SELECT * From public.entrant,public.person where person_id=entrant_id " +
            "and activate_id is null and login_for_lk is not null and password_for_lk is not null")
    List<EntrantForKeycloak> getEntrants();

    @Update("Update public.person set activate_id=#{activate_id} where person_id=#{entrant_id}")
    long updateEntrant(@Param("activate_id") String activate_id, @Param("entrant_id") String entrant_id);
}
