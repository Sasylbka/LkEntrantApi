package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.PassportDataDto;
import ru.esstu.entrant.lk.domain.vo.PassportData;

/**
 * Маппер.
 */
@Slf4j
@Component
public class PassportDataMapper {

    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public PassportDataDto toDto(PassportData vo) {
        if (vo == null) {
            return null;
        }
        return new PassportDataDto(
                vo.getId(),
                vo.getSerial_number(),
                vo.getPlace_of_issue(),
                vo.getCode_of_subdivision(),
                vo.getDate_of_issue()
        );
    }

    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public PassportData toVO(PassportDataDto dto) {
        if (dto == null) {
            return null;
        }
        return new PassportData(
                dto.getId(),
                dto.getSerial_number(),
                dto.getPlace_of_issue(),
                dto.getCode_of_subdivision(),
                dto.getDate_of_issue()
        );
    }
}
