package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.domain.mappers.BenefitInformationMapper;
import ru.esstu.entrant.lk.domain.vo.BenefitInformation;
import ru.esstu.entrant.lk.domain.vo.BenefitInformation;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.repositories.BenefitInformationRepository;

@Service
@Slf4j
public class BenefitInformationService {

    private final BenefitInformationRepository benefitInformationRepository;
    private final BenefitInformationMapper benefitInformationMapper;

    public BenefitInformationService(BenefitInformationRepository benefitInformationRepository,
                                BenefitInformationMapper benefitInformationMapper) {
        this.benefitInformationRepository = benefitInformationRepository;
        this.benefitInformationMapper = benefitInformationMapper;
    }


    public BenefitInformationDto getBenefitInformation(final int id) {
       BenefitInformationDto temp = benefitInformationMapper.toDto(benefitInformationRepository.getBenefitInformation(id));
       if(temp==null){
           temp=new BenefitInformationDto();
           return temp;
       }
       return temp;
    }
    public BenefitInformationDto save(final BenefitInformationDto benefitInformationDto) {
        BenefitInformation entity= benefitInformationMapper.toVO(benefitInformationDto);
        benefitInformationRepository.save(entity);
        return benefitInformationMapper.toDto(entity);
    }
    public BenefitInformationDto update(final BenefitInformationDto benefitInformationDto) {
        BenefitInformation entity= benefitInformationMapper.toVO(benefitInformationDto);
        benefitInformationRepository.update(entity);
        return benefitInformationMapper.toDto(entity);
    }
}