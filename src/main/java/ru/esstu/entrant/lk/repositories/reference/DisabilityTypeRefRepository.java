package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.DisabilityType;

import java.util.List;

@Mapper
public interface DisabilityTypeRefRepository {
    @Select("SELECT * FROM public.disability_type")
    List<DisabilityType> getDisabilityTypes();
}
