package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.EducationInfo;

@Mapper
public interface EducationInfoRepository {
    @Select("SELECT * FROM education_info WHERE id = #{id}")
    EducationInfo getEducationInfo(@Param("id") String id);
}