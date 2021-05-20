package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.DistrictDto;
import ru.esstu.entrant.lk.domain.vo.reference.District;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DistrictRefMapper {
    public DistrictDto toDto(District vo) {
        if (vo == null) {
            return null;
        }
        return new DistrictDto(
                vo.getDistrictId(),
                vo.getDistrictName()
        );
    }
    public District toVO(DistrictDto dto) {
        if (dto == null) {
            return null;
        }
        return new District(
                dto.getDistrictId(),
                dto.getDistrictName()
        );
    }
    public List<DistrictDto> toDtos (List<District> vos) {
        List<DistrictDto> list = new ArrayList<>();
        for (District vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
    
}
