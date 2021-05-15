package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.ChangesDateDto;
import ru.esstu.entrant.lk.domain.vo.ChangesDate;
@Slf4j
@Component
public class ChangesDateMapper {
    public ChangesDateDto toDto(ChangesDate vo) {
        if (vo == null) {
            return null;
        }
        return new ChangesDateDto(
                vo.getId(),
                vo.getEntrantId(),
                vo.getDateOfCreation(),
                vo.getDateOfSend(),
                vo.getDateOfAnswer()
        );
    }
    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public ChangesDate toVO(ChangesDateDto dto) {
        if (dto == null) {
            return null;
        }
        return new ChangesDate(
                dto.getId(),
                dto.getEntrantId(),
                dto.getDateOfCreation(),
                dto.getDateOfSend(),
                dto.getDateOfAnswer()
        );
    }
}
