package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;

import java.util.ArrayList;
import java.util.List;

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
                vo.getEntrantId(),
                vo.getMedal(),
                vo.getHonorsDegree(),
                vo.getOlympiadParticipation(),
                vo.getDocumentOfOlympiadVictories(),
                vo.getDocumentOfOlympiadVictoriesSerialNumber(),
                vo.getIssuedBy(),
                vo.getDataOfIssued(),
                vo.getCandidateMinimumsPassed()
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
                dto.getEntrantId(),
                dto.getMedal(),
                dto.getHonorsDegree(),
                dto.getOlympiadParticipation(),
                dto.getDocumentOfOlympiadVictories(),
                dto.getDocumentOfOlympiadVictoriesSerialNumber(),
                dto.getIssuedBy(),
                dto.getDataOfIssued(),
                dto.getCandidateMinimumsPassed()
        );
    }
    public List<EducationalAchievementsDto> toDtos (List<EducationalAchievements> vos) {
        List<EducationalAchievementsDto> list = new ArrayList<>();
        for (EducationalAchievements vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
