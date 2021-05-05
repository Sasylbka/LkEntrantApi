package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.DistrictDto;
import ru.esstu.entrant.lk.domain.mappers.reference.DistrictRefMapper;
import ru.esstu.entrant.lk.repositories.reference.DistrictRefRepository;

import java.util.List;

@RestController
@Slf4j
public class DistrictRefService {
    private final DistrictRefRepository districtRefRepository;
    private final DistrictRefMapper districtRefMapper;

    public DistrictRefService(DistrictRefRepository districtRefRepository,
                              DistrictRefMapper districtRefMapper) {
        this.districtRefRepository = districtRefRepository;
        this.districtRefMapper = districtRefMapper;
    }

    public List<DistrictDto> getDistricts() {
        return districtRefMapper.toDtos(districtRefRepository.getDistricts());
    }
}
