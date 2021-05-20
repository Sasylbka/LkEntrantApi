package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.DiplomaTypeDto;
import ru.esstu.entrant.lk.services.reference.DiplomaTypeRefService;

import java.util.List;

@RestController
@Slf4j
public class DiplomaTypeRefController {
    /**
 * Сервис.
 */
private final DiplomaTypeRefService diplomaTypeRefService;

    public DiplomaTypeRefController(DiplomaTypeRefService diplomaTypeRefService) {
        this.diplomaTypeRefService = diplomaTypeRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/diplomaType")
    public List<DiplomaTypeDto> get() {
        return diplomaTypeRefService.getDiplomaTypes();
    }
}
