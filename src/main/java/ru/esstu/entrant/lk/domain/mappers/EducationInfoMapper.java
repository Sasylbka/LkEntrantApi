package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.EducationInfoDto;
import ru.esstu.entrant.lk.domain.vo.EducationInfo;

/**
 * Маппер.
 */
@Slf4j
@Component
public class EducationInfoMapper {

    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public EducationInfoDto toDto(EducationInfo vo) {
        if (vo == null) {
            return null;
        }
        return new EducationInfoDto(
                vo.getId(),
                vo.getEntrantId(),
                vo.getEducation(),
                vo.getYearOfFinished(),
                vo.getDocumentOfEducation(),
                vo.getDocumentOfEducationSerialNumber(),
                vo.getPlaceOfFinished(),
                vo.getDateOfFinished(),
                vo.getStudiedLanguage(),
                vo.getIfChoosenLevelOfEducationFirst(),
                vo.getEntranceTest()
        );
    }

    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public EducationInfo toVO(EducationInfoDto dto) {
        if (dto == null) {
            return null;
        }
        return new EducationInfo(
                dto.getId(),
                dto.getEntrantId(),
                dto.getEducation(),
                dto.getYearOfFinished(),
                dto.getDocumentOfEducation(),
                dto.getDocumentOfEducationSerialNumber(),
                dto.getPlaceOfFinished(),
                dto.getDateOfFinished(),
                dto.getStudiedLanguage(),
                dto.getIfChoosenLevelOfEducationFirst(),
                dto.getEntranceTest()
        );
    }
}
