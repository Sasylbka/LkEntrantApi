package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.services.BenefitInformationService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class BenefitInformationController {

    /**
     * Сервис.
     */
    private final BenefitInformationService BenefitInformationService;

    public BenefitInformationController(BenefitInformationService BenefitInformationService) {
        this.BenefitInformationService = BenefitInformationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/BenefitInformation")
    public BenefitInformationDto test(final String id) {
        return BenefitInformationService.getBenefitInformation(id);
    }
}
