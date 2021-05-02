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
                vo.getEntrantId(),
                vo.getSerialNumber(),
                vo.getPlaceOfIssue(),
                vo.getCodeOfSubdivision(),
                vo.getDateOfIssue()
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
                dto.getEntrantId(),
                dto.getSerialNumber(),
                dto.getPlaceOfIssue(),
                dto.getCodeOfSubdivision(),
                dto.getDateOfIssue()
        );
    }
}
