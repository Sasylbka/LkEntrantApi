package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;
import ru.esstu.entrant.lk.services.AdditionalInformationService;

import java.util.List;

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
    @RequestMapping(method = RequestMethod.GET, path = "/additionalInformation")
    public List<AdditionalInformationDto> get(final int id) {
        return additionalInformationService.getAdditionalInformation(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/additionalInformation")
    public AdditionalInformationDto save(@RequestBody final AdditionalInformationDto additionalInformationDto)
    {
        return additionalInformationService.save(additionalInformationDto);
    }
    @RequestMapping(method = RequestMethod.PATCH, path = "/additionalInformation")
    public AdditionalInformationDto update(@RequestBody final AdditionalInformationDto additionalInformationDto)
    {
        return additionalInformationService.update(additionalInformationDto);
    }
}
