package ru.esstu.entrant.lk.repositories.PublicTables;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.PublicTables.RelativeFather;

@Mapper
public interface RelativeFatherPTRepository {
    @Select("SELECT realtive_id, labour_place From public.relative where entrantId=#{person_id} and grade_id=#{5}")
    RelativeFather getFatherId(@Param("person_id")String person_id);
}
