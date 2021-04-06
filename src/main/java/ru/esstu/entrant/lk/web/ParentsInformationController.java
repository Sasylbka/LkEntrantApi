package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.ParentsInformationDto;
import ru.esstu.entrant.lk.services.ParentsInformationService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class ParentsInformationController {

    /**
     * Сервис.
     */
    private final ParentsInformationService ParentsInformationService;

    public ParentsInformationController(ParentsInformationService ParentsInformationService) {
        this.ParentsInformationService = ParentsInformationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/ParentsInformation")
    public ParentsInformationDto test(final String id) {
        return ParentsInformationService.getParentsInformation(id);
    }
}
