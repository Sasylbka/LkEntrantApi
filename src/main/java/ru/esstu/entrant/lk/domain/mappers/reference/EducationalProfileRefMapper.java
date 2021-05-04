package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.EducationalProfileDto;
import ru.esstu.entrant.lk.domain.vo.reference.EducationalProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * Маппер.
 */
@Slf4j
@Component
public class EducationalProfileRefMapper {
    public EducationalProfileDto toDto(EducationalProfile vo) {
        if (vo == null) {
            return null;
        }
        return new EducationalProfileDto(
                vo.getEduProfileId(),
                vo.getEduProfileName()
        );
    }
    public EducationalProfile toVO(EducationalProfileDto dto) {
        if (dto == null) {
            return null;
        }
        return new EducationalProfile(
                dto.getEduProfileId(),
                dto.getEduProfileName()
        );
    }
    public List<EducationalProfileDto> toDtos (List<EducationalProfile> vos) {
        List<EducationalProfileDto> list = new ArrayList<>();
        for (EducationalProfile vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }

}
