package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.CitizenhoodDto;
import ru.esstu.entrant.lk.domain.vo.reference.Citizenhood;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class CitizenhoodRefMapper {
    public CitizenhoodDto toDto(Citizenhood vo) {
        if (vo == null) {
            return null;
        }
        return new CitizenhoodDto(
                vo.getCitId(),
                vo.getName()
        );
    }
    public Citizenhood toVO(CitizenhoodDto dto) {
        if (dto == null) {
            return null;
        }
        return new Citizenhood(
                dto.getCitId(),
                dto.getName()
        );
    }
    public List<CitizenhoodDto> toDtos (List<Citizenhood> vos) {
        List<CitizenhoodDto> list = new ArrayList<>();
        for (Citizenhood vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
