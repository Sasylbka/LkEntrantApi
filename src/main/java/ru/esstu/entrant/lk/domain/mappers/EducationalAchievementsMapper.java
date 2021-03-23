package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;

/**
 * Маппер.
 */
@Slf4j
@Component
public class EducationalAchievementsMapper {

    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public EducationalAchievementsDto toDto(EducationalAchievements vo) {
        if (vo == null) {
            return null;
        }
        return new EducationalAchievementsDto(
                vo.getId(),
                vo.getMedal(),
                vo.getHonors_degree(),
                vo.getOlympiad_participation(),
                vo.getDocument_of_olympiad_victories(),
                vo.getDocument_of_olympiad_victories_serial_number(),
                vo.getIssued_by(),
                vo.getData_of_issued(),
                vo.getCandidate_minimums_passed()
        );
    }

    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public EducationalAchievements toVO(EducationalAchievementsDto dto) {
        if (dto == null) {
            return null;
        }
        return new EducationalAchievements(
                dto.getId(),
                dto.getMedal(),
                dto.getHonors_degree(),
                dto.getOlympiad_participation(),
                dto.getDocument_of_olympiad_victories(),
                dto.getDocument_of_olympiad_victories_serial_number(),
                dto.getIssued_by(),
                dto.getData_of_issued(),
                dto.getCandidate_minimums_passed()
        );
    }
}
