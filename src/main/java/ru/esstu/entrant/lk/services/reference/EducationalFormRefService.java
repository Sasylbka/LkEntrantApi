package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.EducationalFormDto;
import ru.esstu.entrant.lk.domain.mappers.reference.EducationalFormRefMapper;
import ru.esstu.entrant.lk.repositories.reference.EducationalFormRefRepository;

import java.util.List;

@Service
@Slf4j
public class EducationalFormRefService {

    private final EducationalFormRefRepository educationalFormRefRepository;
    private final EducationalFormRefMapper educationalFormRefMapper;

    public EducationalFormRefService(EducationalFormRefRepository educationalFormRefRepository,
                                     EducationalFormRefMapper educationalFormRefMapper) {
        this.educationalFormRefRepository = educationalFormRefRepository;
        this.educationalFormRefMapper = educationalFormRefMapper;
    }

    public List<EducationalFormDto> getEducationalForms() {
        return educationalFormRefMapper.toDtos(educationalFormRefRepository.getEducationalForms());
    }
}