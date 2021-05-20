package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.Dialog;

import java.util.List;

@Mapper
public interface DialogRepository {
    @Select("SELECT * FROM dialog_table WHERE moderator_id = #{id}")
    List<Dialog> getModeratorDialog(@Param("id") int id);

    @Select("SELECT * FROM dialog_table WHERE entrant_id = #{id}")
    List<Dialog> getEntrantDialog(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO dialog_table(moderator_id,entrant_id) " +
            "VALUES(#{dialog.moderatorId},#{dialog.entrantId})")
    long save(@Param("dialog") Dialog dialog);
}
