package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.EntrantStatus;

import java.util.List;

@Mapper
public interface EntrantStatusRefRepository {
    @Select("SELECT * FROM public.entrant_status")
    List<EntrantStatus> getEntrantStatus();
    @Select("Select entrant_status_id From public.entrant_status where entrant_status_name=#{entrantStatusName}")
    EntrantStatus getOne(@Param("entrantStatusName") String entrantStatusName);
}
