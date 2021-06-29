package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.EntrantDocTypeDto;
import ru.esstu.entrant.lk.domain.vo.reference.EntrantDocType;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class EntrantDocTypeRefMapper {
    public EntrantDocTypeDto toDto(EntrantDocType vo) {
        if (vo == null) {
            return null;
        }
        return new EntrantDocTypeDto(
                vo.getDocTypeId(),
                vo.getDocTypeName(),
                vo.getFisId()
        );
    }
    public EntrantDocType toVO(EntrantDocTypeDto dto) {
        if (dto == null) {
            return null;
        }
        return new EntrantDocType(
                dto.getDocTypeId(),
                dto.getDocTypeName(),
                dto.getFisId()
        );
    }
    public List<EntrantDocTypeDto> toDtos (List<EntrantDocType> vos) {
        List<EntrantDocTypeDto> list = new ArrayList<>();
        for (EntrantDocType vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
