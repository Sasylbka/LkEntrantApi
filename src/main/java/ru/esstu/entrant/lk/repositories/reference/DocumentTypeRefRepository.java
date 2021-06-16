package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.DisabilityType;
import ru.esstu.entrant.lk.domain.vo.reference.DocumentType;

import java.util.List;
@Mapper
public interface DocumentTypeRefRepository {
    @Select("SELECT * FROM public.anketa_upload_file_doc_type")
    List<DocumentType> getDocumentTypes();
}
