package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EntrantDto;
import ru.esstu.entrant.lk.domain.vo.Entrant;
import ru.esstu.entrant.lk.services.EntrantService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class EntrantController {

    /**
     * Сервис.
     */
    private final EntrantService entrantService;

    public EntrantController(EntrantService entrantService) {
        this.entrantService = entrantService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/entrant")
    public EntrantDto get(final int id) {
        return entrantService.getEntrant(id);
    }
    @RequestMapping(method = RequestMethod.PATCH, path = "/entrant")
    public EntrantDto update(@RequestBody final EntrantDto entrantDto) {
        return entrantService.update(entrantDto);
    }
    @RequestMapping(method = RequestMethod.PATCH, path = "/entrantStatus")
    public Entrant updateStatus(@RequestBody final Entrant entrant) {
        return entrantService.updateStatus(entrant);
    }
}
