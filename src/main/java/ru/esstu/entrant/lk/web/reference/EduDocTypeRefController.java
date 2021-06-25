package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.EduDocTypeDto;
import ru.esstu.entrant.lk.services.reference.EduDocTypeRefService;

import java.util.List;
@RestController
@Slf4j
public class EduDocTypeRefController {
    /**
     * Сервис.
     */
    private final EduDocTypeRefService eduDocTypeRefService;

    public EduDocTypeRefController(EduDocTypeRefService eduDocTypeRefService) {
        this.eduDocTypeRefService = eduDocTypeRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/eduDocType")
    public List<EduDocTypeDto> get() {
        return eduDocTypeRefService.getEduDocTypes();
    }
}
