package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
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
    @RequestMapping(method = RequestMethod.POST, path = "/AdditionalInformation")
    public AdditionalInformation post(final String id, final String index, final String region,final String area,final String city,final String street,final String number_of_building,final String number_of_apartments)
    {
        return AdditionalInformationService.postAdditionalInformation(id,index,region,area,city,street,number_of_building,number_of_apartments);
    }
}
