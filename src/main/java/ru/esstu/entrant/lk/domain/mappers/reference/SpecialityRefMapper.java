package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.SpecialityDto;
import ru.esstu.entrant.lk.domain.vo.reference.Speciality;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class SpecialityRefMapper {
    public SpecialityDto toDto(Speciality vo) {
        if (vo == null) {
            return null;
        }
        return new SpecialityDto(
                vo.getSpecId(),
                vo.getEduFormId(),
                vo.getEduLevelId(),
                vo.getSpecialityName(),
                vo.getSpecCode()
        );
    }
    public Speciality toVO(SpecialityDto dto) {
        if (dto == null) {
            return null;
        }
        return new Speciality(
                dto.getSpecId(),
                dto.getEduFormId(),
                dto.getEduLevelId(),
                dto.getSpecialityName(),
                dto.getSpecCode()
        );
    }
    public List<SpecialityDto> toDtos (List<Speciality> vos) {
        List<SpecialityDto> list = new ArrayList<>();
        for (Speciality vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
