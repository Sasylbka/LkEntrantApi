package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.Message;
import java.util.List;
@Mapper
public interface MessageRepository {
    @Select("SELECT * FROM message_table WHERE dialog_id = #{id} and role=#{role} order by id")
    List<Message> getMessage(@Param("id") int id, @Param("role")String role);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO message_table(role,dialog_id,sender_id,sender,message,date) " +
            "VALUES(#{message.role},#{message.dialogId},#{message.senderId},#{message.sender},#{message.message},#{message.date})")
    long save(@Param("message") Message message);
    @Select("SELECT * FROM message_table WHERE id = #{id} and role=#{role}")
    Message getLastMessage(@Param("id") int id,@Param("role") String role);
}
