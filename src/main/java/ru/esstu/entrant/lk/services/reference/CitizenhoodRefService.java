package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.CitizenhoodDto;
import ru.esstu.entrant.lk.domain.mappers.reference.CitizenhoodRefMapper;
import ru.esstu.entrant.lk.repositories.reference.CitizenhoodRefRepository;

import java.util.List;
@Service
@Slf4j
public class CitizenhoodRefService {
    private final CitizenhoodRefRepository citizenhoodRefRepository;
    private final CitizenhoodRefMapper citizenhoodRefMapper;

    public CitizenhoodRefService(CitizenhoodRefRepository citizenhoodRefRepository,
                                 CitizenhoodRefMapper citizenhoodRefMapper) {
        this.citizenhoodRefRepository = citizenhoodRefRepository;
        this.citizenhoodRefMapper = citizenhoodRefMapper;
    }

    public List<CitizenhoodDto> getCitizenhoods() {
        return citizenhoodRefMapper.toDtos(citizenhoodRefRepository.getCitizenhoods());
    }
}
