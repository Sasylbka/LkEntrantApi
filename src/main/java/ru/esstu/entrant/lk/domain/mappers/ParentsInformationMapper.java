package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.ParentsInformationDto;
import ru.esstu.entrant.lk.domain.vo.ParentsInformation;
/**
 * Маппер.
 */
@Slf4j
@Component
public class ParentsInformationMapper {
    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public ParentsInformationDto toDto(ParentsInformation vo) {
        if (vo == null) {
            return null;
        }
        return new ParentsInformationDto(
                vo.getId(),
                vo.getEntrantId(),
                vo.getFatherMobileNumber(),
                vo.getFatherName(),
                vo.getFatherSecondName(),
                vo.getFatherPatronymic(),
                vo.getPlaceOfFatherJob(),
                vo.getMotherMobileNumber(),
                vo.getMotherName(),
                vo.getMotherSecondName(),
                vo.getMotherPatronymic(),
                vo.getPlaceOfMotherJob(),
                vo.getAdditionalPhoneNumber()
        );
    }
    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public ParentsInformation toVO(ParentsInformationDto dto) {
        if (dto == null) {
            return null;
        }
        return new ParentsInformation(
                dto.getId(),
                dto.getEntrantId(),
                dto.getFatherMobileNumber(),
                dto.getFatherName(),
                dto.getFatherSecondName(),
                dto.getFatherPatronymic(),
                dto.getPlaceOfFatherJob(),
                dto.getMotherMobileNumber(),
                dto.getMotherName(),
                dto.getMotherSecondName(),
                dto.getMotherPatronymic(),
                dto.getPlaceOfMotherJob(),
                dto.getAdditionalPhoneNumber()
        );
    }
}
