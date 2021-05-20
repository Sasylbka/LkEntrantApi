package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.ChangesDate;
@Mapper
public interface ChangesDateRepository {
    @Select("SELECT * FROM changes_date WHERE entrant_id = #{id}")
    ChangesDate getChangesDate(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO changes_date(date_of_creation,date_of_send,date_of_answer) VALUES( #{ChangesDate.dateOfCreation}, #{ChangesDate.dateOfSend},#{ChangesDate.dateOfAnswer})")
    long save(@Param("ChangesDate") ChangesDate ChangesDate);
    
    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE changes_date SET date_of_creation=#{ChangesDate.dateOfCreation},date_of_send=#{ChangesDate.dateOfSend},date_of_answer=#{ChangesDate.dateOfAnswer}  WHERE entrant_id#{ChangesDate.entrantId}")
    long update(@Param("ChangesDate") ChangesDate ChangesDate);
}
