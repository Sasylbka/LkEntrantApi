package ru.esstu.entrant.lk.services.reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.BenefitKindDto;
import ru.esstu.entrant.lk.domain.mappers.reference.BenefitKindRefMapper;
import ru.esstu.entrant.lk.repositories.reference.BenefitKindRefRepository;

import java.util.List;

@Service
@Slf4j
public class BenefitKindRefService {
    private final BenefitKindRefRepository benefitKindRefRepository;
    private final BenefitKindRefMapper benefitKindRefMapper;

    public BenefitKindRefService(BenefitKindRefRepository benefitKindRefRepository,
                                 BenefitKindRefMapper benefitKindRefMapper) {
        this.benefitKindRefRepository = benefitKindRefRepository;
        this.benefitKindRefMapper = benefitKindRefMapper;
    }

    public List<BenefitKindDto> getBenefitKinds() {
        return benefitKindRefMapper.toDtos(benefitKindRefRepository.getBenefitKinds());
    }
}
