package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.DisabilityTypeDto;
import ru.esstu.entrant.lk.domain.mappers.reference.DisabilityTypeRefMapper;
import ru.esstu.entrant.lk.repositories.reference.DisabilityTypeRefRepository;

import java.util.List;

@Service
@Slf4j
public class DisabilityTypeRefService {
    private final DisabilityTypeRefRepository disabilityTypeRefRepository;
    private final DisabilityTypeRefMapper disabilityTypeRefMapper;

    public DisabilityTypeRefService(DisabilityTypeRefRepository disabilityTypeRefRepository,
                                 DisabilityTypeRefMapper disabilityTypeRefMapper) {
        this.disabilityTypeRefRepository = disabilityTypeRefRepository;
        this.disabilityTypeRefMapper = disabilityTypeRefMapper;
    }

    public List<DisabilityTypeDto> getDisabilityTypes() {
        return disabilityTypeRefMapper.toDtos(disabilityTypeRefRepository.getDisabilityTypes());
    }
}
