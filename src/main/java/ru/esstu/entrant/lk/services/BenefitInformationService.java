package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.domain.mappers.BenefitInformationMapper;
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


    public BenefitInformationDto getBenefitInformation(final String id) {
        return benefitInformationMapper.toDto(benefitInformationRepository.getBenefitInformation(id));
//        return new TestTableDto(1, "NTCN");
    }
    public BenefitInformation postBenefitInformation(final String id, final String reason_for_the_benefit , final String document_for_the_benefit,final String serial_number_document_for_the_benefit,final String issued_by,final String data_of_issued) {
        return benefitInformationMapper.toVO(benefitInformationRepository.postBenefitInformation(id,reason_for_the_benefit,document_for_the_benefit,serial_number_document_for_the_benefit,issued_by,data_of_issued));
    }
}