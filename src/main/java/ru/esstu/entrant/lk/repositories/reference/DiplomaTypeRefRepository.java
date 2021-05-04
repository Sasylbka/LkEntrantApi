package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.DiplomaType;

import java.util.List;

@Mapper
public interface DiplomaTypeRefRepository {
    @Select("SELECT * FROM public.diploma_type")
    List<DiplomaType> getDiplomaTypes();
}
