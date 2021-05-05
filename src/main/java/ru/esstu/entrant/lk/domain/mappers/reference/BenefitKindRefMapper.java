package ru.esstu.entrant.lk.domain.mappers.reference;

import ru.esstu.entrant.lk.domain.dto.reference.BenefitKindDto;
import ru.esstu.entrant.lk.domain.vo.reference.BenefitKind;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class BenefitKindRefMapper
{
    public BenefitKindDto toDto(BenefitKind vo) {
        if (vo == null) {
            return null;
        }
        return new BenefitKindDto(
                vo.getBenefitKindId(),
                vo.getBenefitKindName()
        );
    }
    public BenefitKind toVO(BenefitKindDto dto) {
        if (dto == null) {
            return null;
        }
        return new BenefitKind(
                dto.getBenefitKindId(),
                dto.getBenefitKindName()
        );
    }
    public List<BenefitKindDto> toDtos (List<BenefitKind> vos) {
        List<BenefitKindDto> list = new ArrayList<>();
        for (BenefitKind vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
