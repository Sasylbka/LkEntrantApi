package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.GraduationPlaceDto;
import ru.esstu.entrant.lk.domain.vo.reference.GraduationPlace;

import java.util.ArrayList;
import java.util.List;
@RestController
@Slf4j
public class GraduationPlaceRefMapper {
    public GraduationPlaceDto toDto(GraduationPlace vo) {
        if (vo == null) {
            return null;
        }
        return new GraduationPlaceDto(
                vo.getGraduationPlaceId(),
                vo.getGraduationPlaceName()
        );
    }
    public GraduationPlace toVO(GraduationPlaceDto dto) {
        if (dto == null) {
            return null;
        }
        return new GraduationPlace(
                dto.getGraduationPlaceId(),
                dto.getGraduationPlaceName()
        );
    }
    public List<GraduationPlaceDto> toDtos (List<GraduationPlace> vos) {
        List<GraduationPlaceDto> list = new ArrayList<>();
        for (GraduationPlace vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
