package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.EducationalProfileDto;
import ru.esstu.entrant.lk.services.reference.EducationalProfileRefService;

import java.util.List;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class EducationalProfileRefController {

    /**
     * Сервис.
     */
    private final EducationalProfileRefService educationalProfileRefService;

    public EducationalProfileRefController(EducationalProfileRefService educationalProfileRefService) {
        this.educationalProfileRefService = educationalProfileRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/educationalProfile")
    public List<EducationalProfileDto> get() {
        return educationalProfileRefService.getEducationalProfiles();
    }
}
