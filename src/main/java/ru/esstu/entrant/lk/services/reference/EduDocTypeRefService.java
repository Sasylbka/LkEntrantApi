package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.EduDocTypeDto;
import ru.esstu.entrant.lk.domain.mappers.reference.EduDocTypeRefMapper;
import ru.esstu.entrant.lk.repositories.reference.EduDocTypeRefRepository;

import java.util.List;
@Service
@Slf4j
public class EduDocTypeRefService {
    private final EduDocTypeRefRepository eduDocTypeRefRepository;
    private final EduDocTypeRefMapper eduDocTypeRefMapper;

    public EduDocTypeRefService(EduDocTypeRefRepository eduDocTypeRefRepository,
                                 EduDocTypeRefMapper eduDocTypeRefMapper) {
        this.eduDocTypeRefRepository = eduDocTypeRefRepository;
        this.eduDocTypeRefMapper = eduDocTypeRefMapper;
    }

    public List<EduDocTypeDto> getEduDocTypes() {
        return eduDocTypeRefMapper.toDtos(eduDocTypeRefRepository.getEduDocTypes());
    }
}
