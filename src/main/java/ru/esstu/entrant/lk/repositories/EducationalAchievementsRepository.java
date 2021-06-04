package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;

@Mapper
public interface EducationalAchievementsRepository {
    @Select("SELECT * FROM educational_achievements WHERE entrant_id = #{id}")
    EducationalAchievements getEducationalAchievements(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO educational_achievements(entrant_id, medal, honors_degree, olympiad_participation, document_of_olympiad_victories," +
            "document_of_olympiad_victories_serial_number, issued_by, data_of_issued, candidate_minimums_passed) " +
            "VALUES(#{educationalAchievements.entrantId},#{educationalAchievements.medal},#{educationalAchievements.honorsDegree}," +
            "#{educationalAchievements.olympiadParticipation},#{educationalAchievements.documentOfOlympiadVictories}," +
            "#{educationalAchievements.documentOfOlympiadVictoriesSerialNumber},#{educationalAchievements.issuedBy}," +
            "#{educationalAchievements.dataOfIssued},#{educationalAchievements.candidateMinimumsPassed})")
    long save(@Param("educationalAchievements") EducationalAchievements educationalAchievements);

    @Options(keyProperty = "id", keyColumn = "id")
    @Update("UPDATE educational_achievements SET " +
            "medal=#{educationalAchievements.medal}, honors_degree=#{educationalAchievements.honorsDegree}, " +
            "olympiad_participation=#{educationalAchievements.olympiadParticipation}, " +
            "document_of_olympiad_victories=#{educationalAchievements.documentOfOlympiadVictories}, " +
            "document_of_olympiad_victories_serial_number=#{educationalAchievements.documentOfOlympiadVictoriesSerialNumber}, " +
            "issued_by=#{educationalAchievements.issuedBy}, " +
            "data_of_issued=#{educationalAchievements.dataOfIssued}, candidate_minimums_passed=#{educationalAchievements.candidateMinimumsPassed} " +
            "WHERE entrant_id=#{educationalAchievements.entrantId}")
    long update(@Param("educationalAchievements") EducationalAchievements educationalAchievements);
}
