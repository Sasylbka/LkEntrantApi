package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.EducationalForm;

import java.util.List;

@Mapper
public interface ReferenceRepository {
    @Select("SELECT * FROM public.educational_form")
    List<EducationalForm> getEducationalForms();

    // TO DO остальные справочники
}