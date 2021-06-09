package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.mappers.AdditionalInformationMapper;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;
import ru.esstu.entrant.lk.repositories.AdditionalInformationRepository;

import java.util.List;

@Service
@Slf4j
public class AdditionalInformationService {

    private final AdditionalInformationRepository additionalInformationRepository;
    private final AdditionalInformationMapper additionalInformationMapper;
    private final AccessService accessService;

    public AdditionalInformationService(AdditionalInformationRepository additionalInformationRepository,
                                        AdditionalInformationMapper additionalInformationMapper,
                                        AccessService accessService) {
        this.additionalInformationRepository = additionalInformationRepository;
        this.additionalInformationMapper = additionalInformationMapper;
        this.accessService = accessService;
    }


    public List<AdditionalInformationDto> getAdditionalInformation(final int id) {
        //accessService.commonAccessCheck(id);
        return additionalInformationMapper.toDtos(additionalInformationRepository.getAdditionalInformation(id));
    }

    public AdditionalInformationDto save(final AdditionalInformationDto additionalInformationDto) {
        //accessService.commonAccessCheck(additionalInformationDto.getEntrantId());
        AdditionalInformation entity = additionalInformationMapper.toVO(additionalInformationDto);
        additionalInformationRepository.save(entity);
        return additionalInformationMapper.toDto(entity);
    }

    public AdditionalInformationDto update(final AdditionalInformationDto additionalInformationDto) {
        //accessService.commonAccessCheck(additionalInformationDto.getEntrantId());
        AdditionalInformation entity = additionalInformationMapper.toVO(additionalInformationDto);
        additionalInformationRepository.update(entity);
        return additionalInformationMapper.toDto(entity);
    }

}