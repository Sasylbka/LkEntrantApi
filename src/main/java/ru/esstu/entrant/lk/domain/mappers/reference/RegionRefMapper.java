package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.RegionDto;
import ru.esstu.entrant.lk.domain.vo.reference.Region;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class RegionRefMapper {

    public RegionDto toDto(Region vo) {
        if (vo == null) {
            return null;
        }
        return new RegionDto(
                vo.getRegionId(),
                vo.getRegionName()
        );
    }
    public Region toVO(RegionDto dto) {
        if (dto == null) {
            return null;
        }
        return new Region(
                dto.getRegionId(),
                dto.getRegionName()
        );
    }
    public List<RegionDto> toDtos (List<Region> vos) {
        List<RegionDto> list = new ArrayList<>();
        for (Region vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
