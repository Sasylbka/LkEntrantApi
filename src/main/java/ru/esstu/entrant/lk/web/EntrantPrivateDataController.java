package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EntrantPrivateDataDto;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.services.EntrantPrivateDataService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class EntrantPrivateDataController {

    /**
     * Сервис.
     */
    private final EntrantPrivateDataService EntrantPrivateDataService;

    public EntrantPrivateDataController(EntrantPrivateDataService EntrantPrivateDataService) {
        this.EntrantPrivateDataService = EntrantPrivateDataService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/EntrantPrivateData")
    public EntrantPrivateDataDto test(final String id) {

        return EntrantPrivateDataService.getEntrantPrivateData(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/EntrantPrivateData")
    public EntrantPrivateData post(final String id, final String name , final String family_name, final String patronymic, final String gender, final String date_of_birth, final String city_of_birth, final String region_of_birth) {
        return EntrantPrivateDataService.postEntrantPrivateData(id,name,family_name,patronymic,gender,date_of_birth,city_of_birth,region_of_birth);
    }
}
