package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.DisabilityTypeDto;
import ru.esstu.entrant.lk.services.reference.DiplomaTypeRefService;
import ru.esstu.entrant.lk.services.reference.DisabilityTypeRefService;

import java.util.List;

@RestController
@Slf4j
public class DisabilityTypeRefController {
    private final DisabilityTypeRefService disabilityTypeRefService;
    public DisabilityTypeRefController(DisabilityTypeRefService disabilityTypeRefService) {
        this.disabilityTypeRefService = disabilityTypeRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/disabilityType")
    public List<DisabilityTypeDto> get() {
        return disabilityTypeRefService.getDisabilityTypes();
    }
}
