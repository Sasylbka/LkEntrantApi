package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.services.AdmissionInfoService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class AdmissionInfoController {

    /**
     * Сервис.
     */
    private final AdmissionInfoService AdmissionInfoService;

    public AdmissionInfoController(AdmissionInfoService AdmissionInfoService) {
        this.AdmissionInfoService = AdmissionInfoService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/AdmissionInfo")
    public AdmissionInfoDto test(final String id) {
        return AdmissionInfoService.getAdmissionInfo(id);
    }
}
