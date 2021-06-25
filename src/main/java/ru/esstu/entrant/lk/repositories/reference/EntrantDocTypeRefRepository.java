package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.EntrantDocType;

import java.util.List;
@Mapper
public interface EntrantDocTypeRefRepository {
    @Select("SELECT * FROM public.entrant_doc_type")
    List<EntrantDocType> getEntrantDocTypes();
}
