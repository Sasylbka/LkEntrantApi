package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.SportAchievementsDto;
import ru.esstu.entrant.lk.domain.vo.SportAchievements;

import java.util.ArrayList;
import java.util.List;

/**
 * Маппер.
 */
@Slf4j
@Component
public class SportAchievementsMapper {

    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public SportAchievementsDto toDto(SportAchievements vo) {
        if (vo == null) {
            return null;
        }
        return new SportAchievementsDto(
                vo.getId(),
                vo.getEntrantId(),
                vo.getDocumentOfSportVictories(),
                vo.getDocumentOfSportVictoriesSerialNumber(),
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
    public SportAchievements toVO(SportAchievementsDto dto) {
        if (dto == null) {
            return null;
        }
        return new SportAchievements(
                dto.getId(),
                dto.getEntrantId(),
                dto.getDocumentOfSportVictories(),
                dto.getDocumentOfSportVictoriesSerialNumber(),
                dto.getIssuedBy(),
                dto.getDataOfIssued()
        );
    }
    public List<SportAchievementsDto> toDtos (List<SportAchievements> vos) {
        List<SportAchievementsDto> list = new ArrayList<>();
        for (SportAchievements vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
