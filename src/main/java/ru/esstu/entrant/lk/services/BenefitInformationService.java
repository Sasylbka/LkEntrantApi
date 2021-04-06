package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.domain.mappers.BenefitInformationMapper;
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


    public BenefitInformationDto getBenefitInformation(final String id) {
        return benefitInformationMapper.toDto(benefitInformationRepository.getBenefitInformation(id));
//        return new TestTableDto(1, "NTCN");
    }
}