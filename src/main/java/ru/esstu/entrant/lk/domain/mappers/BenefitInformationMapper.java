package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.domain.vo.BenefitInformation;
/**
 * Маппер.
 */
@Slf4j
@Component
public class BenefitInformationMapper {
    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public BenefitInformationDto toDto(BenefitInformation vo) {
        if (vo == null) {
            return null;
        }
        return new BenefitInformationDto(
                vo.getId(),
                vo.getReason_for_the_benefit(),
                vo.getDocument_for_the_benefit(),
                vo.getSerial_number_document_for_the_benefit(),
                vo.getIssued_by(),
                vo.getData_of_issued()
        );
    }
    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public BenefitInformation toVO(BenefitInformationDto dto) {
        if (dto == null) {
            return null;
        }
        return new BenefitInformation(
                dto.getId(),
                dto.getReason_for_the_benefit(),
                dto.getDocument_for_the_benefit(),
                dto.getSerial_number_document_for_the_benefit(),
                dto.getIssued_by(),
                dto.getData_of_issued()
        );
    }
}
