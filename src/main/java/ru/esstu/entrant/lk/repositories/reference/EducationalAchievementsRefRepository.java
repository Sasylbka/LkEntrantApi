package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.EducationalAchievements;

import java.util.List;

@Mapper
public interface EducationalAchievementsRefRepository {
    @Select("SELECT * FROM public.edu_achievement")
    List<EducationalAchievements> getAchievements();
    @Select("Select achievement_id From public.edu_achievement where achievement_name=#{achievementName}")
    EducationalAchievements getOne(@Param("achievementName") String achievementName);
}
