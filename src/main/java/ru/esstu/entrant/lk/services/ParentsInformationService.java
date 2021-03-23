package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.ParentsInformationDto;
import ru.esstu.entrant.lk.domain.mappers.ParentsInformationMapper;
import ru.esstu.entrant.lk.repositories.ParentsInformationRepository;

@Service
@Slf4j
public class ParentsInformationService {

    private final ParentsInformationRepository parentsInformationRepository;
    private final ParentsInformationMapper parentsInformationMapper;

    public ParentsInformationService(ParentsInformationRepository parentsInformationRepository,
                                ParentsInformationMapper parentsInformationMapper) {
        this.parentsInformationRepository = parentsInformationRepository;
        this.parentsInformationMapper = parentsInformationMapper;
    }


    public ParentsInformationDto getParentsInformation(final String id) {
        return parentsInformationMapper.toDto(parentsInformationRepository.getParentsInformation(id));
//        return new TestTableDto(1, "NTCN");
    }
}