package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.mappers.AdditionalInformationMapper;
import ru.esstu.entrant.lk.domain.mappers.ContactInformationMapper;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;
import ru.esstu.entrant.lk.domain.vo.ContactInformation;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.repositories.AdditionalInformationRepository;

@Service
@Slf4j
public class AdditionalInformationService {

    private final AdditionalInformationRepository additionalInformationRepository;
    private final AdditionalInformationMapper additionalInformationMapper;

    public AdditionalInformationService(AdditionalInformationRepository additionalInformationRepository,
                                AdditionalInformationMapper additionalInformationMapper) {
        this.additionalInformationRepository = additionalInformationRepository;
        this.additionalInformationMapper = additionalInformationMapper;
    }


    public AdditionalInformationDto getAdditionalInformation(final int id) {
        return additionalInformationMapper.toDto(additionalInformationRepository.getAdditionalInformation(id));
    }
    public AdditionalInformationDto save(final AdditionalInformationDto additionalInformationDto) {
        AdditionalInformation entity= additionalInformationMapper.toVO(additionalInformationDto);
        additionalInformationRepository.save(entity);
        return additionalInformationMapper.toDto(entity);
    }
}