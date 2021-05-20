package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.EntrantDto;
import ru.esstu.entrant.lk.domain.vo.Entrant;

@Mapper
public interface EntrantRepository {
    @Select("SELECT * FROM entrant WHERE id = #{id}")
    Entrant getEntrant(@Param("id") int id);

    @Select("SELECT * FROM entrant WHERE keycloak_guid = #{guid}")
    Entrant getEntrantByKeycloakGuid(String guid);

    @Options(useGeneratedKeys = true, keyProperty = "entrant.id", keyColumn = "id")
    @Insert("INSERT INTO entrant(login, password, status, keycloak_guid) VALUES(#{entrant.login},#{entrant.password},#{entrant.status},#{keycloakGuid})")
    long save(@Param("entrant") Entrant entrant, @Param("keycloakGuid") String guid);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE entrant SET login=#{entrant.login}, password=#{entrant.password}, status=#{entrant.status} WHERE id=#{entrant.id}")
    long update(@Param("entrant") Entrant entrant);

    @Options( keyProperty = "id", keyColumn = "id")
    @Update("UPDATE entrant SET status=#{entrant.status} WHERE id=#{entrant.id}")
    long updateStatus(@Param("entrant") Entrant entrant);
}
