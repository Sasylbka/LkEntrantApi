package ru.esstu.entrant.lk.services.reference;

import ru.esstu.entrant.lk.domain.dto.reference.RegionDto;
import ru.esstu.entrant.lk.domain.mappers.reference.RegionRefMapper;
import ru.esstu.entrant.lk.repositories.reference.RegionRefRepository;

import java.util.List;

public class RegionRefService {
    private final RegionRefRepository regionRefRepository;
    private final RegionRefMapper regionRefMapper;

    public RegionRefService(RegionRefRepository regionRefRepository,
                            RegionRefMapper regionRefMapper) {
        this.regionRefRepository = regionRefRepository;
        this.regionRefMapper = regionRefMapper;
    }

    public List<RegionDto> getRegions() {
        return regionRefMapper.toDtos(regionRefRepository.getRegions());
    }
}
