package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.EntrantDto;
import ru.esstu.entrant.lk.domain.vo.Entrant;

/**
 * Маппер.
 */
@Slf4j
@Component
public class EntrantMapper {
    public EntrantDto toDto(Entrant vo) {
        if (vo == null) {
            return null;
        }
        return new EntrantDto(
                vo.getId(),
                vo.getLogin(),
                vo.getPassword()
        );
    }

    public Entrant toVO(EntrantDto dto) {
        if (dto == null) {
            return null;
        }
        return new Entrant(
                dto.getId(),
                dto.getLogin(),
                dto.getPassword()
        );
    }
}
