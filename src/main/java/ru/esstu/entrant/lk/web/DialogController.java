package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.domain.dto.DialogDto;
import ru.esstu.entrant.lk.services.DialogService;
@RestController
@Slf4j
public class DialogController {
    private final DialogService dialogService;

    public DialogController(DialogService dialogService) {
        this.dialogService = dialogService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/edialog")
    public DialogDto get(final int id) {
        return dialogService.getModeratorDialog(id);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/mdialog")
    public DialogDto getEntrant(final int id) {
        return dialogService.getEntrantDialog(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/dialog")
    public DialogDto save(@RequestBody final DialogDto DialogDto) {
        return dialogService.save(DialogDto);
    }
}
