package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.ConsentDto;
import ru.esstu.entrant.lk.domain.dto.ConsentDto;
import ru.esstu.entrant.lk.domain.vo.Consent;
import ru.esstu.entrant.lk.domain.vo.Consent;

import java.util.ArrayList;
import java.util.List;

/**
 * Маппер.
 */
@Slf4j
@Component
public class ConsentMapper {
    /**
     * Преобразование.
     * @param vo объект
     * @return dto
     */
    public ConsentDto toDto(Consent vo) {
        if (vo == null) {
            return null;
        }
        return new ConsentDto(
                vo.getId(),
                vo.getEntrantId(),
                vo.getAdmissionInfoId(),
                vo.getDate(),
                vo.getActionType()
        );
    }
    /**
     * Преобразование.
     * @param dto объект
     * @return dto
     */
    public Consent toVO(ConsentDto dto) {
        if (dto == null) {
            return null;
        }
        return new Consent(
                dto.getId(),
                dto.getEntrantId(),
                dto.getAdmissionInfoId(),
                dto.getDate(),
                dto.getActionType()
        );
    }
    public List<ConsentDto> toDtos (List<Consent> vos) {
        List<ConsentDto> list = new ArrayList<>();
        for (Consent vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
