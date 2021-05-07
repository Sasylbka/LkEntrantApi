package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.Moderator;

@Mapper
public interface ModeratorRepository {
    @Select("SELECT * FROM moderator WHERE id = #{id}")
    Moderator getModerator(@Param("id") int id);
}
