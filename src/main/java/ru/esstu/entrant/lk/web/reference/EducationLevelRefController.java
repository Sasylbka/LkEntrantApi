package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.EducationLevelDto;
import ru.esstu.entrant.lk.services.reference.EducationLevelRefService;
import java.util.List;
@RestController
@Slf4j
public class EducationLevelRefController {
    private final EducationLevelRefService educationLevelRefService;

    public EducationLevelRefController(EducationLevelRefService educationLevelRefService) {
        this.educationLevelRefService = educationLevelRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/educationLevel")
    public List<EducationLevelDto> get() {
        return educationLevelRefService.getEducationLevels();
    }
}
