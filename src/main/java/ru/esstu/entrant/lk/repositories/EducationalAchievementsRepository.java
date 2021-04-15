package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;

@Mapper
public interface EducationalAchievementsRepository {
    @Select("SELECT * FROM educational_achievements WHERE id = #{id}")
    EducationalAchievements getEducationalAchievements(@Param("id") String id);
    @Insert("INSERT INTO educational_achievements VALUES('#{educationalAchievements.id}','#{educationalAchievements.medal}','#{educationalAchievements.honors_degree}','#{educationalAchievements.olympiad_participation}','#{educationalAchievements.document_of_olympiad_victories}','#{educationalAchievements.document_of_olympiad_victories_serial_number}','#{educationalAchievements.issued_by}','#{educationalAchievements.data_of_issued}','#{educationalAchievements.candidate_minimums_passed}')")
    EducationalAchievementsDto postEducationalAchievements(@Param("entity") EducationalAchievements educationalAchievements);
}
