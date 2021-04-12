package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.JobInformationDto;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.services.JobInformationService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class JobInformationController {

    /**
     * Сервис.
     */
    private final JobInformationService JobInformationService;

    public JobInformationController(JobInformationService JobInformationService) {
        this.JobInformationService = JobInformationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/JobInformation")
    public JobInformationDto test(final String id) {
        return JobInformationService.getJobInformation(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/JobInformation")
    public JobInformation post(final String id, final String place_of_job, final String position) {
        return JobInformationService.postJobInformation(id,place_of_job,position);
    }
}
