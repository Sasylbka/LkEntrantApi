package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.EducationLevelDto;
import ru.esstu.entrant.lk.domain.mappers.reference.EducationLevelRefMapper;
import ru.esstu.entrant.lk.repositories.reference.EducationLevelRefRepository;

import java.util.List;
@Service
@Slf4j
public class EducationLevelRefService {
    private final EducationLevelRefRepository educationLevelRefRepository;
    private final EducationLevelRefMapper educationLevelRefMapper;

    public EducationLevelRefService(EducationLevelRefRepository educationLevelRefRepository,
                                        EducationLevelRefMapper educationLevelRefMapper) {
        this.educationLevelRefRepository = educationLevelRefRepository;
        this.educationLevelRefMapper = educationLevelRefMapper;
    }

    public List<EducationLevelDto> getEducationLevels() {
        return educationLevelRefMapper.toDtos(educationLevelRefRepository.getEducationLevels());
    }

}
