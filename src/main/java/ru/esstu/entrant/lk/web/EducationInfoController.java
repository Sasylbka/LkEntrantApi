package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EducationInfoDto;
import ru.esstu.entrant.lk.domain.vo.EducationInfo;
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
    private final EducationInfoService educationInfoService;

    public EducationInfoController(EducationInfoService EducationInfoService) {
        this.educationInfoService = EducationInfoService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/EducationInfo")
    public EducationInfoDto test(final String id) {

        return educationInfoService.getEducationInfo(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/EducationInfo")
    public EducationInfo post(final String id, final String education , final String year_of_finished,final String document_of_education,final String document_of_education_serial_number,final String place_of_finished,final String date_of_finished,final String studied_language,final String if_choosen_level_of_education_first) {
        return educationInfoService.postEducationInfo(id,education,year_of_finished,document_of_education,document_of_education_serial_number,place_of_finished,date_of_finished,studied_language,if_choosen_level_of_education_first);
    }
}
