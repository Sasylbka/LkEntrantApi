package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.dto.ConsentDto;
import ru.esstu.entrant.lk.domain.vo.Consent;
import ru.esstu.entrant.lk.services.AdmissionInfoService;
import ru.esstu.entrant.lk.services.ConsentService;

import java.util.List;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class ConsentController {

    /**
     * Сервис.
     */
    private final ConsentService consentService;
    private final AdmissionInfoService admissionInfoService;
    public ConsentController(ConsentService consentService, AdmissionInfoService admissionInfoService) {
        this.consentService = consentService;
        this.admissionInfoService=admissionInfoService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/consent")
    public List<ConsentDto> get(final int id) {
        return consentService.getConsent(id);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/consentCount")
    public int getCount(final int id) {
        return consentService.getCount(id);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/consentMax")
    public int getMaxWithdrawalOfConsent(final int id) {
        return consentService.getMaxWithdrawalOfConsent(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/consent")
    public ConsentDto save(@RequestBody final ConsentDto consentDto) {
        return consentService.save(consentDto);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/consentAdd")
    public ConsentDto add(@RequestBody final AdmissionInfoDto admissionInfoDto) {
        return consentService.add(admissionInfoDto);
    }
    @RequestMapping(method = RequestMethod.PATCH, path = "/consentAdd")
    public AdmissionInfoDto cancelConsent(@RequestBody final AdmissionInfoDto admissionInfoDto) {
        return consentService.cancelConsent(admissionInfoDto);
    }
}
