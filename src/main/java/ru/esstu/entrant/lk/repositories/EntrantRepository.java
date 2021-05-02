package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.EntrantDto;
import ru.esstu.entrant.lk.domain.vo.Entrant;

@Mapper
public interface EntrantRepository {
    @Select("SELECT * FROM entrant WHERE id = #{id}")
    Entrant getEntrant(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO entrant(login, password) VALUES(#{entrant.login},#{entrant.password})")
    long save(@Param("entrant") Entrant entrant);
}
