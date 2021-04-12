package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.dto.AskOfResultTrialsDto;
import ru.esstu.entrant.lk.domain.vo.AskOfResultTrials;

@Mapper
public interface AskOfResultTrialsRepository {
    @Select("SELECT * FROM ask_of_result_trials WHERE id = #{id}")
    AskOfResultTrials getAskOfResultTrials(@Param("id") String id);
    @Insert("INSERT INTO job_information VALUES('#{id}','#{result}')")
    AskOfResultTrialsDto postAskOfResultTrials(@Param("id") String id, @Param("result") String result);

}