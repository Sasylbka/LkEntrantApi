package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.SportAchievementsDto;
import ru.esstu.entrant.lk.services.SportAchievementsService;

import java.util.List;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class SportAchievementsController {

    /**
     * Сервис.
     */
    private final SportAchievementsService sportAchievementsService;

    public SportAchievementsController(SportAchievementsService sportAchievementsService) {
        this.sportAchievementsService = sportAchievementsService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/sportAchievements")
    public List<SportAchievementsDto> get(final int id) {
        return sportAchievementsService.getSportAchievementsList(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/sportAchievements")
    public SportAchievementsDto save(@RequestBody final SportAchievementsDto sportAchievementsDto) {
        return sportAchievementsService.save(sportAchievementsDto);
    }
    @RequestMapping(method = RequestMethod.PATCH, path = "/sportAchievements")
    public SportAchievementsDto update(@RequestBody final SportAchievementsDto sportAchievementsDto) {
        return sportAchievementsService.update(sportAchievementsDto);
    }
}