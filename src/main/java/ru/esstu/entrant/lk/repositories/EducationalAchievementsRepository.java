package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;

@Mapper
public interface EducationalAchievementsRepository {
    @Select("SELECT * FROM educational_achievements WHERE id = #{id}")
    EducationalAchievements getEducationalAchievements(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO educational_achievements(entrantId, medal, honors_degree, olympiad_participation, document_of_olympiad_victories," +
            "document_of_olympiad_victories_serial_number, issued_by, data_of_issued, candidate_minimums_passed) " +
            "VALUES(#{educationalAchievements.entrantId},#{educationalAchievements.medal},#{educationalAchievements.honors_degree}," +
            "#{educationalAchievements.olympiad_participation},#{educationalAchievements.document_of_olympiad_victories}," +
            "#{educationalAchievements.document_of_olympiad_victories_serial_number},#{educationalAchievements.issued_by}," +
            "#{educationalAchievements.data_of_issued},#{educationalAchievements.candidate_minimums_passed})")
    long save(@Param("educationalAchievements") EducationalAchievements educationalAchievements);
}
