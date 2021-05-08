package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.EntrantDto;
import ru.esstu.entrant.lk.domain.vo.Entrant;

@Mapper
public interface EntrantRepository {
    @Select("SELECT * FROM entrant WHERE id = #{id}")
    Entrant getEntrant(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO entrant(login, password,status) VALUES(#{entrant.login},#{entrant.password},#{entrant.status})")
    long save(@Param("entrant") Entrant entrant);
    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE entrant SET login=#{entrant.login}, password=#{entrant.password}, status=#{entrant.status} WHERE id=#{entrant.id}")
    long update(@Param("entrant") Entrant entrant);
}
