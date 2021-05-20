package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.EducationalFormDto;
import ru.esstu.entrant.lk.services.reference.EducationalFormRefService;

import java.util.List;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class EducationalFormRefController {

    /**
     * Сервис.
     */
    private final EducationalFormRefService educationalFormRefService;

    public EducationalFormRefController(EducationalFormRefService educationalFormRefService) {
        this.educationalFormRefService = educationalFormRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/educationalForm")
    public List<EducationalFormDto> get() {
        return educationalFormRefService.getEducationalForms();
    }
}
