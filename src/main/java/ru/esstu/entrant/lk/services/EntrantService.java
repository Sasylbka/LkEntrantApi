package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.EntrantDto;
import ru.esstu.entrant.lk.domain.mappers.EntrantMapper;
import ru.esstu.entrant.lk.repositories.EntrantRepository;

@Service
@Slf4j
public class EntrantService {

    private final EntrantRepository entrantRepository;
    private final EntrantMapper entrantMapper;

    public EntrantService(EntrantRepository entrantRepository,
                                     EntrantMapper entrantMapper) {
        this.entrantRepository = entrantRepository;
        this.entrantMapper = entrantMapper;
    }

    public EntrantDto getEntrant(final String id) {
        return entrantMapper.toDto(entrantRepository.getEntrant(id));
//        return new TestTableDto(1, "NTCN");
    }
}
