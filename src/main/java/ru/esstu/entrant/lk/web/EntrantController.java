package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EntrantDto;
import ru.esstu.entrant.lk.domain.vo.Entrant;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
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
    private final EntrantService EntrantService;

    public EntrantController(EntrantService EntrantService) {
        this.EntrantService = EntrantService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/Entrant")
    public EntrantDto test(final String id) {

        return EntrantService.getEntrant(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/Entrant")
    public Entrant post(final String id, final String login, final String password) {
        return EntrantService.postEntrant(id,login,password);
    }
}
