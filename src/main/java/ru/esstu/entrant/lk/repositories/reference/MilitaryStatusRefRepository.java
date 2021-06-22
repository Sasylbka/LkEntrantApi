package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.EducationalAchievements;
import ru.esstu.entrant.lk.domain.vo.reference.MilitaryStatus;

import java.util.List;
@Mapper
public interface MilitaryStatusRefRepository {
    @Select("SELECT * FROM public.military_status")
    List<MilitaryStatus> getMilitaryStatus();
    @Select("Select military_status_id From public.military_status where military_status_name=#{militaryStatusName}")
    MilitaryStatus getOne(@Param("militaryStatusName") String militaryStatusName);
}
