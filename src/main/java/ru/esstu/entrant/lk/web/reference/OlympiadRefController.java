package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.OlympiadDto;
import ru.esstu.entrant.lk.services.reference.OlympiadRefService;

import java.util.List;
@RestController
@Slf4j
public class OlympiadRefController {
    private final OlympiadRefService olympiadRefService;

    public OlympiadRefController(OlympiadRefService olympiadRefService) {
        this.olympiadRefService = olympiadRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/olympiad")
    public List<OlympiadDto> get() {
        return olympiadRefService.getOlympiads();
    }
}
