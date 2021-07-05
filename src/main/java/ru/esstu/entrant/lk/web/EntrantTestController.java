package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EntrantTestDto;
import ru.esstu.entrant.lk.services.EntrantTestService;

import java.util.List;

@RestController
@Slf4j
public class EntrantTestController {
    private final EntrantTestService entrantTestService;

    public EntrantTestController(EntrantTestService entrantTestService) {
        this.entrantTestService = entrantTestService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/entrantTest")
    public List<EntrantTestDto> get() {
        return entrantTestService.getEntrantTest();
    }
}
