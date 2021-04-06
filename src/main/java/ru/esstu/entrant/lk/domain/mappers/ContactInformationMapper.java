package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.ContactInformationDto;
import ru.esstu.entrant.lk.domain.vo.ContactInformation;
/**
 * Маппер.
 */
@Slf4j
@Component
public class ContactInformationMapper {
    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public ContactInformationDto toDto(ContactInformation vo) {
        if (vo == null) {
            return null;
        }
        return new ContactInformationDto(
                vo.getId(),
                vo.getMobile_number()
        );
    }
    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public ContactInformation toVO(ContactInformationDto dto) {
        if (dto == null) {
            return null;
        }
        return new ContactInformation(
                dto.getId(),
                dto.getMobile_number()
        );
    }
}
