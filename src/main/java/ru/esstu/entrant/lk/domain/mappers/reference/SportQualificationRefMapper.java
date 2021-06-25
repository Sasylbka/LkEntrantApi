package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.SportQualificationDto;
import ru.esstu.entrant.lk.domain.vo.reference.SportQualification;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class SportQualificationRefMapper {
    public SportQualificationDto toDto(SportQualification vo) {
        if (vo == null) {
            return null;
        }
        return new SportQualificationDto(
                vo.getSportQualificationId(),
                vo.getSportQualificationName()
        );
    }
    public SportQualification toVO(SportQualificationDto dto) {
        if (dto == null) {
            return null;
        }
        return new SportQualification(
                dto.getSportQualificationId(),
                dto.getSportQualificationName()
        );
    }
    public List<SportQualificationDto> toDtos (List<SportQualification> vos) {
        List<SportQualificationDto> list = new ArrayList<>();
        for (SportQualification vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
