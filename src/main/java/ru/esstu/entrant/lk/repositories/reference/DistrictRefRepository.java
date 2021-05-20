package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.District;

import java.util.List;
@Mapper
public interface DistrictRefRepository {
    @Select("SELECT * FROM public.district")
    List<District> getDistricts();
}
