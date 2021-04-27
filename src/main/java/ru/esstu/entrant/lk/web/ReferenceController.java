package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.EducationalFormDto;
import ru.esstu.entrant.lk.services.ContactInformationService;
import ru.esstu.entrant.lk.services.ReferenceService;

import java.util.List;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class ReferenceController {

    /**
     * Сервис.
     */
    private final ReferenceService referenceService;

    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/educationalForm")
    public List<EducationalFormDto> get() {
        return referenceService.getEducationalForms();
    }
}
