package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Маппер.
 */
@Slf4j
@Component
public class AdmissionInfoMapper {

    public AdmissionInfoDto toDto(AdmissionInfo vo) {
        if (vo == null) {
            return null;
        }
        return new AdmissionInfoDto(
                vo.getId(),
                vo.getEntrantId(),
                vo.getLevelOfEducation(),
                vo.getDirection(),
                vo.getAdmittanceCategory(),
                vo.isAccelerated(),
                vo.isBudget(),
                vo.isContract(),
                vo.isTargetedTraining(),
                vo.isQuota(),
                vo.isConsentBudget(),
                vo.isConsentTarget(),
                vo.isConsentQuote()

        );
    }
    public AdmissionInfo toVO(AdmissionInfoDto dto) {
        if (dto == null) {
            return null;
        }
        return new AdmissionInfo(
                dto.getId(),
                dto.getEntrantId(),
                dto.getLevelOfEducation(),
                dto.getDirection(),
                dto.getAdmittanceCategory(),
                dto.isAccelerated(),
                dto.isBudget(),
                dto.isContract(),
                dto.isTargetedTraining(),
                dto.isQuota(),
                dto.isConsentBudget(),
                dto.isConsentTarget(),
                dto.isConsentQuote()
        );
    }
    public List<AdmissionInfoDto> toDtos (List<AdmissionInfo> vos) {
        List<AdmissionInfoDto> list = new ArrayList<>();
        for (AdmissionInfo vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
