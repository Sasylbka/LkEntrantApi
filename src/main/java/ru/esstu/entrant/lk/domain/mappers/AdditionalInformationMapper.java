package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.dto.MessageDto;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;
import ru.esstu.entrant.lk.domain.vo.Message;

import java.util.ArrayList;
import java.util.List;

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
                vo.getEntrantId(),
                vo.getIndex(),
                vo.getRegion(),
                vo.getArea(),
                vo.getCity(),
                vo.getStreet(),
                vo.getNumberOfBuilding(),
                vo.getNumberOfApartments(),
                vo.getType(),
                vo.isCoincides(),
                vo.isReservist(),
                vo.isNeedsHostel()
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
                dto.getEntrantId(),
                dto.getIndex(),
                dto.getRegion(),
                dto.getArea(),
                dto.getCity(),
                dto.getStreet(),
                dto.getNumberOfBuilding(),
                dto.getNumberOfApartments(),
                dto.getType(),
                dto.isCoincides(),
                dto.isReservist(),
                dto.isNeedsHostel()
        );
    }
    public List<AdditionalInformationDto> toDtos (List<AdditionalInformation> vos) {
        List<AdditionalInformationDto> list = new ArrayList<>();
        for (AdditionalInformation vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
