package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.CitizenhoodDto;
import ru.esstu.entrant.lk.services.reference.CitizenhoodRefService;
import ru.esstu.entrant.lk.services.reference.CitizenhoodRefService;

import java.util.List;
@RestController
@Slf4j
public class CitizenhoodRefController {
    private final CitizenhoodRefService citizenhoodRefService;
    public CitizenhoodRefController(CitizenhoodRefService citizenhoodRefService) {
        this.citizenhoodRefService = citizenhoodRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/citizenhood")
    public List<CitizenhoodDto> get() {
        return citizenhoodRefService.getCitizenhoods();
    }
}
