package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.services.AdditionalInformationService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class AdditionalInformationController {

    /**
     * Сервис.
     */
    private final AdditionalInformationService AdditionalInformationService;

    public AdditionalInformationController(AdditionalInformationService AdditionalInformationService) {
        this.AdditionalInformationService = AdditionalInformationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/AdditionalInformation")
    public AdditionalInformationDto test(final String id) {
        return AdditionalInformationService.getAdditionalInformation(id);
    }
}
