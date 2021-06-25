package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.EduDocType;

import java.util.List;

@Mapper
public interface EduDocTypeRefRepository {
    @Select("SELECT * FROM public.edu_doc_type")
    List<EduDocType> getEduDocTypes();
}
