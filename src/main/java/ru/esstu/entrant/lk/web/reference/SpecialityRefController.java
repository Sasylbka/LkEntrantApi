package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.SpecialityDto;
import ru.esstu.entrant.lk.services.reference.SpecialityRefService;

import java.util.List;
@RestController
@Slf4j
public class SpecialityRefController {
    private final SpecialityRefService specialityRefService;

    public SpecialityRefController(SpecialityRefService specialityRefService) {
        this.specialityRefService = specialityRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/speciality")
    public List<SpecialityDto> get() {
        return specialityRefService.getSpecialities();
    }
}
