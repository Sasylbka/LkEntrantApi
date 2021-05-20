package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.EducationalProfileDto;
import ru.esstu.entrant.lk.domain.mappers.reference.EducationalProfileRefMapper;
import ru.esstu.entrant.lk.repositories.reference.EducationalProfileRefRepository;

import java.util.List;

@Service
@Slf4j
public class EducationalProfileRefService {

    private final EducationalProfileRefRepository educationalProfileRefRepository;
    private final EducationalProfileRefMapper educationalProfileRefMapper;

    public EducationalProfileRefService(EducationalProfileRefRepository educationalProfileRefRepository,
                                     EducationalProfileRefMapper educationalProfileRefMapper) {
        this.educationalProfileRefRepository = educationalProfileRefRepository;
        this.educationalProfileRefMapper = educationalProfileRefMapper;
    }

    public List<EducationalProfileDto> getEducationalProfiles() {
        return educationalProfileRefMapper.toDtos(educationalProfileRefRepository.getEducationalProfiles());
    }
}