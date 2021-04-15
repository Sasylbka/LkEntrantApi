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
    @RequestMapping(method = RequestMethod.GET, path = "/Entrant")
    public EntrantDto get(final String id) {
        return entrantService.getEntrant(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/Entrant")
    public Entrant save(@RequestBody final EntrantDto entrantDto) {
        return entrantService.postEntrant(entrantDto);
    }
}
