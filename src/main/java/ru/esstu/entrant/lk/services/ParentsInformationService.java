package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.ParentsInformationDto;
import ru.esstu.entrant.lk.domain.mappers.ParentsInformationMapper;
import ru.esstu.entrant.lk.domain.vo.ParentsInformation;
import ru.esstu.entrant.lk.repositories.ParentsInformationRepository;

@Service
@Slf4j
public class ParentsInformationService {

    private final ParentsInformationRepository parentsInformationRepository;
    private final ParentsInformationMapper parentsInformationMapper;
    private final AccessService accessService;

    public ParentsInformationService(ParentsInformationRepository parentsInformationRepository,
                                     ParentsInformationMapper parentsInformationMapper,
                                     AccessService accessService) {
        this.parentsInformationRepository = parentsInformationRepository;
        this.parentsInformationMapper = parentsInformationMapper;
        this.accessService = accessService;
    }

    public ParentsInformationDto getParentsInformation(final int id) {
        accessService.commonAccessCheck(id);
        ParentsInformationDto temp = parentsInformationMapper.toDto(parentsInformationRepository.getParentsInformation(id));
        if(temp==null){
            temp=new ParentsInformationDto();
            return temp;
        }
        return temp;
    }
    public ParentsInformationDto save(final ParentsInformationDto parentsInformationDto) {
        accessService.commonAccessCheck(parentsInformationDto.getEntrantId());
        ParentsInformation entity= parentsInformationMapper.toVO(parentsInformationDto);
        parentsInformationRepository.save(entity);
        return parentsInformationMapper.toDto(entity);
    }
    public ParentsInformationDto update(final ParentsInformationDto parentsInformationDto) {
        accessService.commonAccessCheck(parentsInformationDto.getEntrantId());
        ParentsInformation entity= parentsInformationMapper.toVO(parentsInformationDto);
        parentsInformationRepository.update(entity);
        return parentsInformationMapper.toDto(entity);
    }
}