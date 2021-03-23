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
                vo.getEducation(),
                vo.getYear_of_finished(),
                vo.getDocument_of_education(),
                vo.getDocument_of_education_serial_number(),
                vo.getPlace_of_finished(),
                vo.getDate_of_finished(),
                vo.getStudied_language(),
                vo.getIf_choosen_level_of_education_first()
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
                dto.getEducation(),
                dto.getYear_of_finished(),
                dto.getDocument_of_education(),
                dto.getDocument_of_education_serial_number(),
                dto.getPlace_of_finished(),
                dto.getDate_of_finished(),
                dto.getStudied_language(),
                dto.getIf_choosen_level_of_education_first()
        );
    }
}
