package ru.esstu.entrant.lk.repositories.PublicTables;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.PublicTables.EducationalDocument;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;

@Mapper
public interface EducationalDocumentPTRepository {
    @Select("SELECT entrant_id From public.educational_document where doc_series=#{serial} and doc_number=#{number}")
    EducationalDocument getDocument(@Param("serial")String serial, @Param("number")String number);
}
