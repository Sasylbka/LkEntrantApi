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
    @Insert("INSERT INTO job_information VALUES('#{id}','#{medal}','#{honors_degree}','#{olympiad_participation}','#{document_of_olympiad_victories}','#{document_of_olympiad_victories_serial_number}','#{issued_by}','#{data_of_issued}','#{candidate_minimums_passed}')")
    EducationalAchievementsDto postEducationalAchievements(@Param("id") String id, @Param("medal") String medal, @Param("honors_degree") String honors_degree, @Param("olympiad_participation") String olympiad_participation, @Param("document_of_olympiad_victories") String document_of_olympiad_victories, @Param("document_of_olympiad_victories_serial_number") String document_of_olympiad_victories_serial_number, @Param("issued_by") String issued_by, @Param("data_of_issued") String data_of_issued, @Param("candidate_minimums_passed") String candidate_minimums_passed);
}
