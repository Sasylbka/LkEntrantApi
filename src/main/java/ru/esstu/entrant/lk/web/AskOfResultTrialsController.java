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
    @RequestMapping(method = RequestMethod.GET, path = "/askOfResultTrials")
    public AskOfResultTrialsDto get(final int id) {
        return askOfResultTrialsService.getAskOfResultTrials(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/askOfResultTrials")
    public AskOfResultTrialsDto save(@RequestBody final AskOfResultTrialsDto askOfResultTrialsDto) {
        return askOfResultTrialsService.save(askOfResultTrialsDto);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/askOfResultTrials")
    public AskOfResultTrialsDto update(@RequestBody final AskOfResultTrialsDto askOfResultTrialsDto) {
        return askOfResultTrialsService.update(askOfResultTrialsDto);
    }
}
