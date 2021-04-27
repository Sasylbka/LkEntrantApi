package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.EducationalFormDto;
import ru.esstu.entrant.lk.domain.mappers.ReferenceMapper;
import ru.esstu.entrant.lk.repositories.ReferenceRepository;

import java.util.List;

@Service
@Slf4j
public class ReferenceService {

    private final ReferenceRepository referenceRepository;
    private final ReferenceMapper referenceMapper;

    public ReferenceService(ReferenceRepository referenceRepository,
                            ReferenceMapper referenceMapper) {
        this.referenceRepository = referenceRepository;
        this.referenceMapper = referenceMapper;
    }


    public List<EducationalFormDto> getEducationalForms() {
        return referenceMapper.toDtos(referenceRepository.getEducationalForms());
    }
}