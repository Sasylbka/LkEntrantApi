package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.AskOfResultTrialsDto;
import ru.esstu.entrant.lk.domain.vo.AskOfResultTrials;

/**
 * Маппер.
 */
@Slf4j
@Component
public class AskOfResultTrialsMapper {

    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public AskOfResultTrialsDto toDto(AskOfResultTrials vo) {
        if (vo == null) {
            return null;
        }
        return new AskOfResultTrialsDto(
                vo.getId(),
                vo.getResult()
        );
    }

    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public AskOfResultTrials toVO(AskOfResultTrialsDto dto) {
        if (dto == null) {
            return null;
        }
        return new AskOfResultTrials(
                dto.getId(),
                dto.getResult()
        );
    }
}
