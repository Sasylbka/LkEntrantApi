package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AskOfResultTrialsDto;
import ru.esstu.entrant.lk.domain.vo.AskOfResultTrials;

@Mapper
public interface AskOfResultTrialsRepository {
    @Select("SELECT * FROM ask_of_result_trials WHERE entrant_id = #{id}")
    AskOfResultTrials getAskOfResultTrials(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO ask_of_result_trials(entrant_id, result) " +
            "VALUES(#{askOfResultTrials.entrantId},#{askOfResultTrials.result})")
    long save(@Param("askOfResultTrials") AskOfResultTrials askOfResultTrials);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE ask_of_result_trials SET " +
            "result=#{askOfResultTrials.result} WHERE entrant_id=#{askOfResultTrials.entrantId}")
    long update(@Param("askOfResultTrials") AskOfResultTrials askOfResultTrials);

}