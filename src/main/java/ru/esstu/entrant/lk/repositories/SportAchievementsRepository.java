package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.SportAchievements;

import java.util.List;

@Mapper
public interface SportAchievementsRepository {
    @Select("SELECT * FROM sport_achievements WHERE entrant_id = #{id}")
    List<SportAchievements> getSportAchievementsList(@Param("id") int id);

    @Select("SELECT * FROM sport_achievements WHERE entrant_id = #{id}")
    List<SportAchievements> getSportAchievements(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO sport_achievements(entrant_id, document_of_sport_victories," +
            "document_of_sport_victories_serial_number, issued_by, data_of_issued) " +
            "VALUES(#{sportAchievements.entrantId}," +
            "#{sportAchievements.documentOfSportVictories}," +
            "#{sportAchievements.documentOfSportVictoriesSerialNumber},#{sportAchievements.issuedBy}," +
            "#{sportAchievements.dataOfIssued})")
    long save(@Param("sportAchievements") SportAchievements sportAchievements);

    @Options(keyProperty = "id", keyColumn = "id")
    @Update("UPDATE sport_achievements SET " +
            "document_of_sport_victories=#{sportAchievements.documentOfSportVictories}, " +
            "document_of_sport_victories_serial_number=#{sportAchievements.documentOfSportVictoriesSerialNumber}, " +
            "issued_by=#{sportAchievements.issuedBy}, " +
            "data_of_issued=#{sportAchievements.dataOfIssued} " +
            "WHERE entrant_id=#{sportAchievements.entrantId}")
    long update(@Param("sportAchievements") SportAchievements sportAchievements);
}
