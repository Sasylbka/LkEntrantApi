package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.domain.vo.BenefitInformation;
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
    private final BenefitInformationService benefitInformationService;

    public BenefitInformationController(BenefitInformationService benefitInformationService) {
        this.benefitInformationService = benefitInformationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/benefitInformation")
    public BenefitInformationDto get(final int id) {
        return benefitInformationService.getBenefitInformation(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/benefitInformation")
    public BenefitInformationDto save(@RequestBody final BenefitInformationDto benefitInformationDto) {
        return benefitInformationService.save(benefitInformationDto);
    }
}
