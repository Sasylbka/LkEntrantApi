package ru.esstu.entrant.lk.web.reference;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.esstu.entrant.lk.domain.dto.reference.OlimpiadDto;
import ru.esstu.entrant.lk.services.reference.OlimpiadRefService;

import java.util.List;

public class OlimpiadRefController {
    private final OlimpiadRefService olimpiadRefService;

    public OlimpiadRefController(OlimpiadRefService olimpiadRefService) {
        this.olimpiadRefService = olimpiadRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/olimpiad")
    public List<OlimpiadDto> get() {
        return olimpiadRefService.getOlimpiads();
    }
}
