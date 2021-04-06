package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.ContactInformationDto;
import ru.esstu.entrant.lk.services.ContactInformationService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class ContactInformationController {

    /**
     * Сервис.
     */
    private final ContactInformationService ContactInformationService;

    public ContactInformationController(ContactInformationService ContactInformationService) {
        this.ContactInformationService = ContactInformationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/ContactInformation")
    public ContactInformationDto test(final String id) {
        return ContactInformationService.getContactInformation(id);
    }
}
