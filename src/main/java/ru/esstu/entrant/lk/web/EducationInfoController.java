package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EducationInfoDto;
import ru.esstu.entrant.lk.services.EducationInfoService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class EducationInfoController {

    /**
     * Сервис.
     */
    private final EducationInfoService EducationInfoService;

    public EducationInfoController(EducationInfoService EducationInfoService) {
        this.EducationInfoService = EducationInfoService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/EducationInfo")
    public EducationInfoDto test(final String id) {
        return EducationInfoService.getEducationInfo(id);
    }
}
