package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.MilitaryStatus;
import ru.esstu.entrant.lk.domain.vo.reference.SportQualification;

import java.util.List;

@Mapper
public interface SportQualificationRefRepository {
    @Select("SELECT * FROM public.sport_qualification")
    List<SportQualification> getSportQualification();
    @Select("Select sport_qualification_id From public.sport_qualification where sport_qualification_name=#{sportQualificationName}")
    SportQualification getOne(@Param("sportQualificationName") String sportQualificationName);
}
