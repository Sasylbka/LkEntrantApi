package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.ModeratorDto;
import ru.esstu.entrant.lk.services.ModeratorService;
@RestController
@Slf4j
public class ModeratorController {
    private final ModeratorService moderatorService;

    public ModeratorController(ModeratorService moderatorService) {
        this.moderatorService = moderatorService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/moderator")
    public ModeratorDto get(final int id) {
        return moderatorService.getModerator(id);
    }
}
