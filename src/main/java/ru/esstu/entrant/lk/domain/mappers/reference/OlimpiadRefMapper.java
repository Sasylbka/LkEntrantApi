package ru.esstu.entrant.lk.domain.mappers.reference;

import ru.esstu.entrant.lk.domain.dto.reference.OlimpiadDto;
import ru.esstu.entrant.lk.domain.vo.reference.Olimpiad;

import java.util.ArrayList;
import java.util.List;

public class OlimpiadRefMapper {
    public OlimpiadDto toDto(Olimpiad vo) {
        if (vo == null) {
            return null;
        }
        return new OlimpiadDto(
                vo.getOlimpiadId(),
                vo.getOlimpiadName()
        );
    }
    public Olimpiad toVO(OlimpiadDto dto) {
        if (dto == null) {
            return null;
        }
        return new Olimpiad(
                dto.getOlimpiadId(),
                dto.getOlimpiadName()
        );
    }
    public List<OlimpiadDto> toDtos (List<Olimpiad> vos) {
        List<OlimpiadDto> list = new ArrayList<>();
        for (Olimpiad vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
