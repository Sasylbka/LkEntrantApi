package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.EntrantDocTypeDto;
import ru.esstu.entrant.lk.services.reference.EntrantDocTypeRefService;

import java.util.List;
@RestController
@Slf4j
public class EntrantDocTypeRefController {
    /**
     * Сервис.
     */
    private final EntrantDocTypeRefService entrantDocTypeRefService;

    public EntrantDocTypeRefController(EntrantDocTypeRefService entrantDocTypeRefService) {
        this.entrantDocTypeRefService = entrantDocTypeRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/entrantDocType")
    public List<EntrantDocTypeDto> get() {
        return entrantDocTypeRefService.getEntrantDocTypes();
    }
}
