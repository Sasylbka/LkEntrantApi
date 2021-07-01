package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import ru.esstu.entrant.lk.domain.vo.UsersGoogleFcm;

@Repository
@Mapper
public interface GoogleFcmRepository {
    @Select("SELECT * FROM users_google_fcm WHERE user_id = #{userId}")
    UsersGoogleFcm findByUserId(@Param("userId") String userId);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO users_google_fcm(user_id, platform, token) VALUES(#{usersGoogleFcm.userId}, " +
            "#{usersGoogleFcm.platform}, #{usersGoogleFcm.token})")
    long save(@Param("usersGoogleFcm") UsersGoogleFcm usersGoogleFcm);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE users_google_fcm SET " +
            "platform=#{usersGoogleFcm.platform}, token=#{usersGoogleFcm.token} WHERE user_id=#{usersGoogleFcm.userId}")
    long update(@Param("usersGoogleFcm") UsersGoogleFcm usersGoogleFcm);

    @Options(keyProperty = "id", keyColumn = "id")
    @Delete("DELETE from users_google_fcm " +
            "WHERE id=#{id}")
    void delete(@Param("id") int id);
}
