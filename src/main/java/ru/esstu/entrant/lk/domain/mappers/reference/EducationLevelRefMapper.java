package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.EducationLevelDto;
import ru.esstu.entrant.lk.domain.vo.reference.EducationLevel;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class EducationLevelRefMapper {
    public EducationLevelDto toDto(EducationLevel vo) {
        if (vo == null) {
            return null;
        }
        return new EducationLevelDto(
                vo.getEduLevelId(),
                vo.getEduLevelName()
        );
    }
    public EducationLevel toVO(EducationLevelDto dto) {
        if (dto == null) {
            return null;
        }
        return new EducationLevel(
                dto.getEduLevelId(),
                dto.getEduLevelName()
        );
    }
    public List<EducationLevelDto> toDtos (List<EducationLevel> vos) {
        List<EducationLevelDto> list = new ArrayList<>();
        for (EducationLevel vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
