package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;
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
    private final EducationalAchievementsService educationalAchievementsService;

    public EducationalAchievementsController(EducationalAchievementsService educationalAchievementsService) {
        this.educationalAchievementsService = educationalAchievementsService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/EducationalAchievements")
    public EducationalAchievementsDto get(final String id) {
        return educationalAchievementsService.getEducationalAchievements(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/EducationalAchievements")
    public EducationalAchievements save(@RequestBody final EducationalAchievementsDto educationalAchievementsDto) {
        return educationalAchievementsService.postEducationalAchievements(educationalAchievementsDto);
    }
}
