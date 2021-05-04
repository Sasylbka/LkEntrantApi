package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.BenefitKindDto;
import ru.esstu.entrant.lk.services.reference.BenefitKindRefService;

import java.util.List;
@RestController
@Slf4j
public class BenefitKindRefController {
    /**
     * Сервис.
     */
    private final BenefitKindRefService benefitKindRefService;

    public BenefitKindRefController(BenefitKindRefService benefitKindRefService) {
        this.benefitKindRefService = benefitKindRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/benefitKind")
    public List<BenefitKindDto> get() {
        return benefitKindRefService.getBenefitKinds();
    }
}
