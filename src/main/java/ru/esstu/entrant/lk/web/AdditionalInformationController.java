package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;
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
    private final AdditionalInformationService additionalInformationService;

    public AdditionalInformationController(AdditionalInformationService additionalInformationService) {
        this.additionalInformationService = additionalInformationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/AdditionalInformation")
    public AdditionalInformationDto get(final String id) {
        return additionalInformationService.getAdditionalInformation(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/AdditionalInformation")
    public AdditionalInformation save(@RequestBody final AdditionalInformationDto additionalInformationDto)
    {
        return additionalInformationService.postAdditionalInformation(additionalInformationDto);
    }
}
