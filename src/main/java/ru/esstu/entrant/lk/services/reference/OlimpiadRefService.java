package ru.esstu.entrant.lk.services.reference;

import ru.esstu.entrant.lk.domain.dto.reference.OlimpiadDto;
import ru.esstu.entrant.lk.domain.mappers.reference.OlimpiadRefMapper;
import ru.esstu.entrant.lk.repositories.reference.OlimpiadRefRepository;

import java.util.List;

public class OlimpiadRefService {
    private final OlimpiadRefRepository olimpiadRefRepository;
    private final OlimpiadRefMapper olimpiadRefMapper;

    public OlimpiadRefService(OlimpiadRefRepository olimpiadRefRepository,
                            OlimpiadRefMapper olimpiadRefMapper) {
        this.olimpiadRefRepository = olimpiadRefRepository;
        this.olimpiadRefMapper = olimpiadRefMapper;
    }

    public List<OlimpiadDto> getOlimpiads() {
        return olimpiadRefMapper.toDtos(olimpiadRefRepository.getOlimpiads());
    }
}
