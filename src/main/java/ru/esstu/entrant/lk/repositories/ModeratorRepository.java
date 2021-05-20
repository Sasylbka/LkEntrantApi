package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.Moderator;

@Mapper
public interface ModeratorRepository {
    @Select("SELECT * FROM moderator WHERE id = #{id}")
    Moderator getModerator(@Param("id") int id);

    @Select("SELECT * FROM moderator WHERE keycloak_guid = #{keycloakGuid}")
    Moderator getModeratorByKeycloakGuid(@Param("keycloakGuid") String guid);

    @Options(useGeneratedKeys = true, keyProperty = "moderator.id", keyColumn = "id")
    @Insert("INSERT INTO moderator(login, password, first_name, second_name, patronymic, keycloak_guid) VALUES" +
            "(#{moderator.login},#{moderator.password}," +
            "#{moderator.first_name},#{moderator.second_name},#{moderator.patronymic},#{keycloakGuid})")
    long save(@Param("moderator") Moderator moderator, @Param("keycloakGuid") String guid);
}
