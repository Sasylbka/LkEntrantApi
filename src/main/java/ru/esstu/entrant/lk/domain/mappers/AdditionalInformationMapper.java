package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;
/**
 * Маппер.
 */
@Slf4j
@Component
public class AdditionalInformationMapper {
    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public AdditionalInformationDto toDto(AdditionalInformation vo) {
        if (vo == null) {
            return null;
        }
        return new AdditionalInformationDto(
                vo.getId(),
                vo.getIndex(),
                vo.getRegion(),
                vo.getArea(),
                vo.getCity(),
                vo.getStreet(),
                vo.getNumberOfBuilding(),
                vo.getNumberOfApartments()
        );
    }
    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public AdditionalInformation toVO(AdditionalInformationDto dto) {
        if (dto == null) {
            return null;
        }
        return new AdditionalInformation(
                dto.getId(),
                dto.getIndex(),
                dto.getRegion(),
                dto.getArea(),
                dto.getCity(),
                dto.getStreet(),
                dto.getNumberOfBuilding(),
                dto.getNumberOfApartments()
        );
    }
}
