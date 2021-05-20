package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.DiplomaTypeDto;
import ru.esstu.entrant.lk.domain.mappers.reference.DiplomaTypeRefMapper;
import ru.esstu.entrant.lk.repositories.reference.DiplomaTypeRefRepository;

import java.util.List;
@Service
@Slf4j
public class DiplomaTypeRefService {
    private final DiplomaTypeRefRepository diplomaTypeRefRepository;
    private final DiplomaTypeRefMapper diplomaTypeRefMapper;

    public DiplomaTypeRefService(DiplomaTypeRefRepository diplomaTypeRefRepository,
                                 DiplomaTypeRefMapper diplomaTypeRefMapper) {
        this.diplomaTypeRefRepository = diplomaTypeRefRepository;
        this.diplomaTypeRefMapper = diplomaTypeRefMapper;
    }

    public List<DiplomaTypeDto> getDiplomaTypes() {
        return diplomaTypeRefMapper.toDtos(diplomaTypeRefRepository.getDiplomaTypes());
    }
}
