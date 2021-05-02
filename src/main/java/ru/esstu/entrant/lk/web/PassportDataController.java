package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.PassportDataDto;
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
    private final PassportDataService passportDataService;

    public PassportDataController(PassportDataService passportDataService) {
        this.passportDataService = passportDataService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/passportData")
    public PassportDataDto get(final int id) {
        return passportDataService.getPassportData(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/passportData")
    public PassportDataDto save(@RequestBody final PassportDataDto passportDataDto) {
        return passportDataService.save(passportDataDto);
    }
}
