package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.AdmittanceCategoryDto;
import ru.esstu.entrant.lk.domain.mappers.reference.AdmittanceCategoryRefMapper;
import ru.esstu.entrant.lk.repositories.reference.AdmittanceCategoryRefRepository;

import java.util.List;
@Service
@Slf4j
public class AdmittanceCategoryRefService {
    private final AdmittanceCategoryRefRepository admittanceCategoryRefRepository;
    private final AdmittanceCategoryRefMapper admittanceCategoryRefMapper;

    public AdmittanceCategoryRefService(AdmittanceCategoryRefRepository admittanceCategoryRefRepository,
                                 AdmittanceCategoryRefMapper admittanceCategoryRefMapper) {
        this.admittanceCategoryRefRepository = admittanceCategoryRefRepository;
        this.admittanceCategoryRefMapper = admittanceCategoryRefMapper;
    }

    public List<AdmittanceCategoryDto> getAdmittanceCategories() {
        return admittanceCategoryRefMapper.toDtos(admittanceCategoryRefRepository.getAdmittanceCategories());
    }
}
