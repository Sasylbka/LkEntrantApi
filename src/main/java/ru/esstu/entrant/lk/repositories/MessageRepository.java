package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.Message;
import java.util.List;
@Mapper
public interface MessageRepository {
    @Select("SELECT * FROM message_table WHERE dialog_id = #{id}")
    List<Message> getMessage(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO message_table(dialog_id,sender_id,sender,message,date) " +
            "VALUES(#{message.dialogId},#{message.senderId},#{message.sender},#{message.message},#{message.date})")
    long save(@Param("message") Message message);

}
