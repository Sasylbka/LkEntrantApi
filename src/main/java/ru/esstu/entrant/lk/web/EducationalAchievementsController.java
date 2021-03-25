package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
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
}
