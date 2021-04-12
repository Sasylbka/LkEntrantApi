package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.PassportDataDto;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.domain.vo.PassportData;
import ru.esstu.entrant.lk.services.PassportDataService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class PassportDataController {

    /**
     * Сервис.
     */
    private final PassportDataService PassportDataService;

    public PassportDataController(PassportDataService PassportDataService) {
        this.PassportDataService = PassportDataService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/PassportData")
    public PassportDataDto test(final String id) {
        return PassportDataService.getPassportData(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/PassportData")
    public PassportData post(final String id, final String serial_number , final String place_of_issue,final String code_of_subdivision,final String date_of_issue) {
        return PassportDataService.postPassportData(id,serial_number,place_of_issue,code_of_subdivision,date_of_issue);
    }
}
