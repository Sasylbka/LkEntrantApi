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

import java.util.List;

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


    public List<AdditionalInformationDto> getAdditionalInformation(final int id) {
        List<AdditionalInformationDto> temp=additionalInformationMapper.toDtos(additionalInformationRepository.getAdditionalInformation(id));
        if(temp.size()==0){
            AdditionalInformationDto additionalInformationDto=new AdditionalInformationDto(0,0,null,null,null,null,null,null,null,null);
            temp.add(additionalInformationDto);
            return temp;
        }
        return temp;
    }
    public AdditionalInformationDto save(final AdditionalInformationDto additionalInformationDto) {
        AdditionalInformation entity= additionalInformationMapper.toVO(additionalInformationDto);
        additionalInformationRepository.save(entity);
        return additionalInformationMapper.toDto(entity);
    }
    public AdditionalInformationDto update(final AdditionalInformationDto additionalInformationDto) {
        AdditionalInformation entity= additionalInformationMapper.toVO(additionalInformationDto);
        additionalInformationRepository.update(entity);
        return additionalInformationMapper.toDto(entity);
    }

}