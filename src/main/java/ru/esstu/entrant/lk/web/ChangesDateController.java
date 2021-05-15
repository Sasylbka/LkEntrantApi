package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.ChangesDateDto;
import ru.esstu.entrant.lk.services.ChangesDateService;
@RestController
@Slf4j
public class ChangesDateController {
    private final ChangesDateService ChangesDateService;

    public ChangesDateController(ChangesDateService ChangesDateService) {
        this.ChangesDateService = ChangesDateService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/changesDate")
    public ChangesDateDto get(final int id) {

        return ChangesDateService.getChangesDate(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/changesDate")
    public ChangesDateDto save(@RequestBody final ChangesDateDto ChangesDateDto) {
        return ChangesDateService.save(ChangesDateDto);
    }
    @RequestMapping(method = RequestMethod.PATCH, path = "/changesDate")
    public ChangesDateDto update(@RequestBody final ChangesDateDto ChangesDateDto) {
        return ChangesDateService.update(ChangesDateDto);
    }
}
