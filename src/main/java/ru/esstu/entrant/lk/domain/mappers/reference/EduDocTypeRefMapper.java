package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.EduDocTypeDto;
import ru.esstu.entrant.lk.domain.vo.reference.EduDocType;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class EduDocTypeRefMapper {
    public EduDocTypeDto toDto(EduDocType vo) {
        if (vo == null) {
            return null;
        }
        return new EduDocTypeDto(
                vo.getEduDocTypeId(),
                vo.getEduDocTypeName(),
                vo.getForPostgraduate()
        );
    }
    public EduDocType toVO(EduDocTypeDto dto) {
        if (dto == null) {
            return null;
        }
        return new EduDocType(
                dto.getEduDocTypeId(),
                dto.getEduDocTypeName(),
                dto.getForPostgraduate()
        );
    }
    public List<EduDocTypeDto> toDtos (List<EduDocType> vos) {
        List<EduDocTypeDto> list = new ArrayList<>();
        for (EduDocType vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
