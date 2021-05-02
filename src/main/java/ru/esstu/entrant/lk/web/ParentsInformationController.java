package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.ParentsInformationDto;
import ru.esstu.entrant.lk.domain.vo.ParentsInformation;
import ru.esstu.entrant.lk.services.ParentsInformationService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class ParentsInformationController {

    /**
     * Сервис.
     */
    private final ParentsInformationService parentsInformationService;

    public ParentsInformationController(ParentsInformationService parentsInformationService) {
        this.parentsInformationService = parentsInformationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/parentsInformation")
    public ParentsInformationDto get(final int id) {

        return parentsInformationService.getParentsInformation(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/parentsInformation")
    public ParentsInformationDto save(@RequestBody final ParentsInformationDto parentsInformationDto) {
        return parentsInformationService.save(parentsInformationDto);
    }
}
