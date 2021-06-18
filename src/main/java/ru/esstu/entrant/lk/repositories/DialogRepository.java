package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.Dialog;

import java.util.List;

@Mapper
public interface DialogRepository {
    @Select("SELECT * FROM dialog_table WHERE moderator_role = #{moderator_role}")
    List<Dialog> getModeratorDialog(@Param("moderator_role") String moderator_role);

    @Select("SELECT * FROM dialog_table WHERE entrant_id = #{id}")
    List<Dialog> getEntrantDialog(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO dialog_table(moderator_role,entrant_id, last_message) " +
            "VALUES(#{dialog.moderatorRole},#{dialog.entrantId},#{dialog.lastMessage})")
    long save(@Param("dialog") Dialog dialog);
}
