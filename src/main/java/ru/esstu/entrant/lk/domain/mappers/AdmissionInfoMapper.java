package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;
/**
 * Маппер.
 */
@Slf4j
@Component
public class AdmissionInfoMapper {
    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public AdmissionInfoDto toDto(AdmissionInfo vo) {
        if (vo == null) {
            return null;
        }
        return new AdmissionInfoDto(
                vo.getId(),
                vo.getLevelOfEducation(),
                vo.getFirstDirection(),
                vo.getSecondDirection(),
                vo.getThirdDirection()
        );
    }
    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public AdmissionInfo toVO(AdmissionInfoDto dto) {
        if (dto == null) {
            return null;
        }
        return new AdmissionInfo(
                dto.getId(),
                dto.getLevelOfEducation(),
                dto.getFirstDirection(),
                dto.getSecondDirection(),
                dto.getThirdDirection()
        );
    }
}
