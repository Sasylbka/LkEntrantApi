package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;

@Mapper
public interface EducationalAchievementsRepository {
    @Select("SELECT * FROM educational_achievements WHERE id = #{id}")
    EducationalAchievements getEducationalAchievements(@Param("id") String id);
}
