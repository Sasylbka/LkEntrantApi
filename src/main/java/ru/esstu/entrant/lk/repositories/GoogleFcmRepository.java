package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import ru.esstu.entrant.lk.domain.vo.UsersGoogleFcm;

@Repository
@Mapper
public interface GoogleFcmRepository {
    @Select("SELECT * FROM users_google_fcm WHERE user_id = #{userId} AND platform = #{platform} LIMIT 1")
    UsersGoogleFcm findByUserIdAndPlatform(@Param("userId") String userId, @Param("platform") String platform);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO users_google_fcm(user_id, platform, token) VALUES(#{usersGoogleFcm.userId}, " +
            "#{usersGoogleFcm.platform}, #{usersGoogleFcm.token})")
    long save(@Param("usersGoogleFcm") UsersGoogleFcm usersGoogleFcm);
}
