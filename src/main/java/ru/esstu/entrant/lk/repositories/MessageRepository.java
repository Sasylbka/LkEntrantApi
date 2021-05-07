package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.Message;
@Mapper
public interface MessageRepository {
    @Select("SELECT * FROM message_table WHERE dialog_id = #{id}")
    Message getMessage(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO message_table(dialogId,message,date) " +
            "VALUES(#{message.dialog_id},#{message.message},#{message.date})")
    long save(@Param("message") Message message);
}
