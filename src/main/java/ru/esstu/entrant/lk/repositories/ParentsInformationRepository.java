package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.ParentsInformation;

@Mapper
public interface ParentsInformationRepository {
    @Select("SELECT * FROM parents_information WHERE id = #{id}")
    ParentsInformation getParentsInformation(@Param("id") String id);
}