package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.ConsentDto;
import ru.esstu.entrant.lk.domain.vo.Consent;
import ru.esstu.entrant.lk.services.ConsentService;

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

    public ConsentController(ConsentService consentService) {
        this.consentService = consentService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/consent")
    public ConsentDto get(final int id) {
        return consentService.getConsent(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/consent")
    public ConsentDto save(@RequestBody final ConsentDto consentDto) {
        return consentService.save(consentDto);
    }
    @RequestMapping(method = RequestMethod.PATCH, path = "/consent")
    public ConsentDto update(@RequestBody final ConsentDto consentDto) {
        return consentService.update(consentDto);
    }
}
