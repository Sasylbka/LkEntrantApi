package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.SportQualificationDto;
import ru.esstu.entrant.lk.services.reference.SportQualificationRefService;

import java.util.List;
@RestController
@Slf4j
public class SportQualificationRefController {

    private final SportQualificationRefService sportQualificationRefService;
    public SportQualificationRefController(SportQualificationRefService sportQualificationRefService) {
        this.sportQualificationRefService = sportQualificationRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/sportQualification")
    public List<SportQualificationDto> get() {
        return sportQualificationRefService.getSpecialities();
    }
}
