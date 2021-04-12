package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.mappers.AdditionalInformationMapper;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;
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


    public AdditionalInformationDto getAdditionalInformation(final String id) {
        return additionalInformationMapper.toDto(additionalInformationRepository.getAdditionalInformation(id));
//        return new TestTableDto(1, "NTCN");
    }
    public AdditionalInformation postAdditionalInformation(final String id, final String index, final String region,final String area,final String city,final String street,final String number_of_building,final String number_of_apartments) {
        return additionalInformationMapper.toVO(additionalInformationRepository.postAdditionalInformation(id,index,region,area,city,street,number_of_building,number_of_apartments));
    }
}