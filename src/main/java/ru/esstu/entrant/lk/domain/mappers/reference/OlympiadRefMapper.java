package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.OlympiadDto;
import ru.esstu.entrant.lk.domain.vo.reference.Olympiad;

import java.util.ArrayList;
import java.util.List;
@RestController
@Slf4j
public class OlympiadRefMapper {
    public OlympiadDto toDto(Olympiad vo) {
        if (vo == null) {
            return null;
        }
        return new OlympiadDto(
                vo.getOlimpiadId(),
                vo.getOlimpiadNumber(),
                vo.getOlimpiadName()

        );
    }
    public Olympiad toVO(OlympiadDto dto) {
        if (dto == null) {
            return null;
        }
        return new Olympiad(
                dto.getOlimpiadId(),
                dto.getOlimpiadNumber(),
               dto.getOlimpiadName()
        );
    }
    public List<OlympiadDto> toDtos (List<Olympiad> vos) {
        List<OlympiadDto> list = new ArrayList<>();
        for (Olympiad vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
