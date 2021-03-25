package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EntrantPrivateDataDto;
import ru.esstu.entrant.lk.services.EntrantPrivateDataService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class EntrantPrivateDataController {

    /**
     * Сервис.
     */
    private final EntrantPrivateDataService EntrantPrivateDataService;

    public EntrantPrivateDataController(EntrantPrivateDataService EntrantPrivateDataService) {
        this.EntrantPrivateDataService = EntrantPrivateDataService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/EntrantPrivateData")
    public EntrantPrivateDataDto test(final String id) {
        return EntrantPrivateDataService.getEntrantPrivateData(id);
    }
}
