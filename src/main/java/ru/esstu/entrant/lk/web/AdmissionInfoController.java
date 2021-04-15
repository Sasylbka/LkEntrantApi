package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;
import ru.esstu.entrant.lk.services.AdmissionInfoService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class AdmissionInfoController {

    /**
     * Сервис.
     */
    private final AdmissionInfoService admissionInfoService;

    public AdmissionInfoController(AdmissionInfoService AdmissionInfoService) {
        this.admissionInfoService = AdmissionInfoService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/AdmissionInfo")
    public AdmissionInfoDto test(final String id) {

        return admissionInfoService.getAdmissionInfo(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/AdmissionInfo")
    public AdmissionInfo post(final String id, final String level_of_education, final String first_direction, final String second_direction, final String third_direction) {
        return admissionInfoService.postAdmissionInfo(id,level_of_education,first_direction,second_direction,third_direction);
    }
}
