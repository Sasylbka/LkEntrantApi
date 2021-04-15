package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EntrantPrivateDataDto;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;
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
    private final EntrantPrivateDataService entrantPrivateDataService;

    public EntrantPrivateDataController(EntrantPrivateDataService entrantPrivateDataService) {
        this.entrantPrivateDataService = entrantPrivateDataService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/EntrantPrivateData")
    public EntrantPrivateDataDto get(final String id) {

        return entrantPrivateDataService.getEntrantPrivateData(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/EntrantPrivateData")
    public EntrantPrivateData save(@RequestBody final EntrantPrivateDataDto entrantPrivateDataDto) {
        return entrantPrivateDataService.postEntrantPrivateData(entrantPrivateDataDto);
    }
}
