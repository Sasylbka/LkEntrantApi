package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.DocumentTypeDto;
import ru.esstu.entrant.lk.domain.vo.reference.DocumentType;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class DocumentTypeRefMapper {
    public DocumentTypeDto toDto(DocumentType vo) {
        if (vo == null) {
            return null;
        }
        return new DocumentTypeDto(
                vo.getId(),
                vo.getName(),
                vo.getForPostgraduate()
        );
    }
    public DocumentType toVO(DocumentTypeDto dto) {
        if (dto == null) {
            return null;
        }
        return new DocumentType(
                dto.getId(),
                dto.getName(),
                dto.getForPostgraduate()
        );
    }
    public List<DocumentTypeDto> toDtos (List<DocumentType> vos) {
        List<DocumentTypeDto> list = new ArrayList<>();
        for (DocumentType vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }

}
