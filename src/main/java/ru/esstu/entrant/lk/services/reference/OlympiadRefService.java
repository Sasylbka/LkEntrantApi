package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.OlympiadDto;
import ru.esstu.entrant.lk.domain.mappers.reference.OlympiadRefMapper;
import ru.esstu.entrant.lk.repositories.reference.OlympiadRefRepository;

import java.util.List;
@RestController
@Slf4j
public class OlympiadRefService {
    private final OlympiadRefRepository olympiadRefRepository;
    private final OlympiadRefMapper olympiadRefMapper;

    public OlympiadRefService(OlympiadRefRepository olympiadRefRepository,
                              OlympiadRefMapper olympiadRefMapper) {
        this.olympiadRefRepository = olympiadRefRepository;
        this.olympiadRefMapper = olympiadRefMapper;
    }

    public List<OlympiadDto> getOlympiads() {
        return olympiadRefMapper.toDtos(olympiadRefRepository.getOlympiads());
    }
}
