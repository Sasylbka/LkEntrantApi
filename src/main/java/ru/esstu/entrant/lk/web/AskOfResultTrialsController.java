package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.AskOfResultTrialsDto;
import ru.esstu.entrant.lk.domain.vo.AskOfResultTrials;
import ru.esstu.entrant.lk.services.AskOfResultTrialsService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class AskOfResultTrialsController {

    /**
     * Сервис.
     */
    private final AskOfResultTrialsService askOfResultTrialsService;

    public AskOfResultTrialsController(AskOfResultTrialsService askOfResultTrialsService) {
        this.askOfResultTrialsService = askOfResultTrialsService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/AskOfResultTrials")
    public AskOfResultTrialsDto get(final String id) {
        return askOfResultTrialsService.getAskOfResultTrials(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/AskOfResultTrials")
    public AskOfResultTrials save(@RequestBody final AskOfResultTrialsDto askOfResultTrialsDto) {
        return askOfResultTrialsService.postAskOfResultTrials(askOfResultTrialsDto);
    }
}
