package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.AskOfResultTrialsDto;
import ru.esstu.entrant.lk.domain.vo.AskOfResultTrials;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
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
    private final AskOfResultTrialsService AskOfResultTrialsService;

    public AskOfResultTrialsController(AskOfResultTrialsService AskOfResultTrialsService) {
        this.AskOfResultTrialsService = AskOfResultTrialsService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/AskOfResultTrials")
    public AskOfResultTrialsDto test(final String id) {
        return AskOfResultTrialsService.getAskOfResultTrials(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/AskOfResultTrials")
    public AskOfResultTrials post(final String id, final String result) {
        return AskOfResultTrialsService.postAskOfResultTrials(id,result);
    }
}
