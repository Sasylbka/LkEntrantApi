package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AskOfResultTrialsDto;
import ru.esstu.entrant.lk.domain.vo.AskOfResultTrials;

@Mapper
public interface AskOfResultTrialsRepository {
    @Select("SELECT * FROM ask_of_result_trials WHERE id = #{id}")
    AskOfResultTrials getAskOfResultTrials(@Param("id") String id);
    @Insert("INSERT INTO ask_of_result_trials VALUES('#{askOfResultTrials.id}','#{askOfResultTrials.result}')")
    AskOfResultTrialsDto postAskOfResultTrials(@Param("entity") AskOfResultTrials askOfResultTrials);

}