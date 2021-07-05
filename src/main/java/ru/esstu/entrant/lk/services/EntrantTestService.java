package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.EntrantTestDto;
import ru.esstu.entrant.lk.domain.mappers.EntrantTestMapper;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;
import ru.esstu.entrant.lk.repositories.AdmissionInfoRepository;
import ru.esstu.entrant.lk.repositories.EntrantTestRepository;
import ru.esstu.entrant.lk.repositories.reference.SpecialityRefRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EntrantTestService {
    private final EntrantTestRepository entrantTestRepository;
    private final EntrantTestMapper entrantTestMapper;
    private final AccessService accessService;
    private final AdmissionInfoRepository admissionInfoRepository;
    private final SpecialityRefRepository specialityRefRepository;

    public EntrantTestService(EntrantTestRepository entrantTestRepository,
                              EntrantTestMapper entrantTestMapper,
                              AdmissionInfoRepository admissionInfoRepository,
                              SpecialityRefRepository specialityRefRepository,
                              AccessService accessService) {
        this.entrantTestRepository = entrantTestRepository;
        this.entrantTestMapper = entrantTestMapper;
        this.accessService = accessService;
        this.admissionInfoRepository = admissionInfoRepository;
        this.specialityRefRepository = specialityRefRepository;
    }

    public List<EntrantTestDto> getEntrantTest(final String guid) {
        List<EntrantTestDto> temp = entrantTestMapper.toDtos(entrantTestRepository.getEntrantTest(guid));
        return temp;
    }
}
