package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.DiplomaTypeDto;
import ru.esstu.entrant.lk.domain.vo.reference.DiplomaType;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class DiplomaTypeRefMapper {
    public DiplomaTypeDto toDto(DiplomaType vo) {
        if (vo == null) {
            return null;
        }
        return new DiplomaTypeDto(
                vo.getDipTypeId(),
                vo.getDipTypeName()
        );
    }
    public DiplomaType toVO(DiplomaTypeDto dto) {
        if (dto == null) {
            return null;
        }
        return new DiplomaType(
                dto.getDipTypeId(),
                dto.getDipTypeName()
        );
    }
    public List<DiplomaTypeDto> toDtos (List<DiplomaType> vos) {
        List<DiplomaTypeDto> list = new ArrayList<>();
        for (DiplomaType vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
