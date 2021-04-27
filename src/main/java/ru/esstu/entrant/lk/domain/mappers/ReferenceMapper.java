package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.EducationalFormDto;
import ru.esstu.entrant.lk.domain.vo.reference.EducationalForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Маппер.
 */
@Slf4j
@Component
public class ReferenceMapper {
    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public EducationalFormDto toDto(EducationalForm vo) {
        if (vo == null) {
            return null;
        }
        return new EducationalFormDto(
                vo.getEduFormId(),
                vo.getEduFormName()
        );
    }

    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public EducationalForm toVO(EducationalFormDto dto) {
        if (dto == null) {
            return null;
        }
        return new EducationalForm(
                dto.getEduFormId(),
                dto.getEduFormName()
        );
    }

    public List<EducationalFormDto> toDtos(List<EducationalForm> vos) {
        List<EducationalFormDto> list = new ArrayList<>();
        for (EducationalForm vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
