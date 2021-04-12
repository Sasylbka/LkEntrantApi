package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.services.EducationalAchievementsService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class EducationalAchievementsController {

    /**
     * Сервис.
     */
    private final EducationalAchievementsService EducationalAchievementsService;

    public EducationalAchievementsController(EducationalAchievementsService EducationalAchievementsService) {
        this.EducationalAchievementsService = EducationalAchievementsService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/EducationalAchievements")
    public EducationalAchievementsDto test(final String id) {
        return EducationalAchievementsService.getEducationalAchievements(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/EducationalAchievements")
    public EducationalAchievements post(final String id, final String medal , final String honors_degree, final String olympiad_participation, final String document_of_olympiad_victories, final String document_of_olympiad_victories_serial_number, final String issued_by, final String data_of_issued, final String candidate_minimums_passed) {
        return EducationalAchievementsService.postEducationalAchievements(id,medal,honors_degree,olympiad_participation,document_of_olympiad_victories,document_of_olympiad_victories_serial_number,issued_by,data_of_issued,candidate_minimums_passed);
    }
}
