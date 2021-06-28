package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.GraduationPlaceDto;
import ru.esstu.entrant.lk.domain.mappers.reference.GraduationPlaceRefMapper;
import ru.esstu.entrant.lk.repositories.reference.GraduationPlaceRefRepository;

import java.util.List;
@Service
@Slf4j
public class GraduationPlaceRefService {
    private final GraduationPlaceRefRepository GraduationPlaceRefRepository;
    private final GraduationPlaceRefMapper GraduationPlaceRefMapper;

    public GraduationPlaceRefService(GraduationPlaceRefRepository GraduationPlaceRefRepository,
                            GraduationPlaceRefMapper GraduationPlaceRefMapper) {
        this.GraduationPlaceRefRepository = GraduationPlaceRefRepository;
        this.GraduationPlaceRefMapper = GraduationPlaceRefMapper;
    }

    public List<GraduationPlaceDto> getGraduationPlaces() {
        return GraduationPlaceRefMapper.toDtos(GraduationPlaceRefRepository.getGraduationPlaces());
    }
}
