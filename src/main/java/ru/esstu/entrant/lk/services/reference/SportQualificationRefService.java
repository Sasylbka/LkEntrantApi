package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.SportQualificationDto;
import ru.esstu.entrant.lk.domain.mappers.reference.SportQualificationRefMapper;
import ru.esstu.entrant.lk.domain.vo.reference.SportQualification;
import ru.esstu.entrant.lk.repositories.reference.SportQualificationRefRepository;

import java.util.List;

@Service
@Slf4j
public class SportQualificationRefService {
    private final SportQualificationRefRepository sportQualificationRefRepository;
    private final SportQualificationRefMapper sportQualificationRefMapper;

    public SportQualificationRefService(SportQualificationRefRepository sportQualificationRefRepository,
                                SportQualificationRefMapper sportQualificationRefMapper) {
        this.sportQualificationRefRepository = sportQualificationRefRepository;
        this.sportQualificationRefMapper = sportQualificationRefMapper;
    }

    public List<SportQualificationDto> getSpecialities() {
        List<SportQualification> temp=sportQualificationRefRepository.getSportQualification();
        return sportQualificationRefMapper.toDtos(temp);
    }
}
