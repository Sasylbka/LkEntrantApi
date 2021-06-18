package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.EntrantPrivateDataDto;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;

/**
 * Маппер.
 */
@Slf4j
@Component
public class EntrantPrivateDataMapper {
    public EntrantPrivateDataDto toDto(EntrantPrivateData vo) {
        if (vo == null) {
            return null;
        }
        return new EntrantPrivateDataDto(
                vo.getId(),
                vo.getEntrantId(),
                vo.getName(),
                vo.getFamilyName(),
                vo.getPatronymic(),
                vo.getGender(),
                vo.getDateOfBirth(),
                vo.getCityOfBirth(),
                vo.getRegionOfBirth(),
                vo.getSnills(),
                vo.getReservist(),
                vo.getNeedsHostel()
        );
    }

    public EntrantPrivateData toVO(EntrantPrivateDataDto dto) {
        if (dto == null) {
            return null;
        }
        return new EntrantPrivateData(
                dto.getId(),
                dto.getEntrantId(),
                dto.getName(),
                dto.getFamilyName(),
                dto.getPatronymic(),
                dto.getGender(),
                dto.getDateOfBirth(),
                dto.getCityOfBirth(),
                dto.getRegionOfBirth(),
                dto.getSnills(),
                dto.getReservist(),
                dto.getNeedsHostel()
        );
    }
}
