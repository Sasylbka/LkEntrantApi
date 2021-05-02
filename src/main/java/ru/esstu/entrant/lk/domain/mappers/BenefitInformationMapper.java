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
                vo.getEntrantId(),
                vo.getReasonForTheBenefit(),
                vo.getDocumentForTheBenefit(),
                vo.getSerialNumberDocumentForTheBenefit(),
                vo.getIssuedBy(),
                vo.getDataOfIssued()
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
                dto.getEntrantId(),
                dto.getReasonForTheBenefit(),
                dto.getDocumentForTheBenefit(),
                dto.getSerialNumberDocumentForTheBenefit(),
                dto.getIssuedBy(),
                dto.getDataOfIssued()
        );
    }
}
