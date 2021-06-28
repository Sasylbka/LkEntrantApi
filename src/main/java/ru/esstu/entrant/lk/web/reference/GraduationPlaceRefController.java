package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.GraduationPlaceDto;
import ru.esstu.entrant.lk.services.reference.GraduationPlaceRefService;

import java.util.List;
@RestController
@Slf4j
public class GraduationPlaceRefController {
    private final GraduationPlaceRefService GraduationPlaceRefService;

    public GraduationPlaceRefController(GraduationPlaceRefService GraduationPlaceRefService) {
        this.GraduationPlaceRefService = GraduationPlaceRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/graduationPlace")
    public List<GraduationPlaceDto> get() {
        return GraduationPlaceRefService.getGraduationPlaces();
    }
}
