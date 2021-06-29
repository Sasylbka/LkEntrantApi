package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.GraduationPlace;

import java.util.List;
@Mapper
public interface GraduationPlaceRefRepository {
    @Select("SELECT * FROM public.graduation_place")
    List<GraduationPlace> getGraduationPlaces();
}
