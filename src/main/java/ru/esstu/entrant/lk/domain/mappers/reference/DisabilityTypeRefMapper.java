package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.DisabilityTypeDto;
import ru.esstu.entrant.lk.domain.vo.reference.DisabilityType;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DisabilityTypeRefMapper {
    public DisabilityTypeDto toDto(DisabilityType vo) {
    if (vo == null) {
        return null;
    }
    return new DisabilityTypeDto(
            vo.getDisTypeId(),
            vo.getDisTypeName()
    );
}
    public DisabilityType toVO(DisabilityTypeDto dto) {
        if (dto == null) {
            return null;
        }
        return new DisabilityType(
                dto.getDisTypeId(),
                dto.getDisTypeName()
        );
    }
    public List<DisabilityTypeDto> toDtos (List<DisabilityType> vos) {
        List<DisabilityTypeDto> list = new ArrayList<>();
        for (DisabilityType vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
