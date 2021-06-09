package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.domain.dto.DialogDto;
import ru.esstu.entrant.lk.services.DialogService;

import java.util.List;

@RestController
@Slf4j
public class DialogController {
    private final DialogService dialogService;

    public DialogController(DialogService dialogService) {
        this.dialogService = dialogService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/mdialog")
    public List<DialogDto> get(final int id,final String role) {
        return dialogService.getModeratorDialog(id,role);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/edialog")
    public List<DialogDto> getEntrant(final int id) {
        return dialogService.getEntrantDialog(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/dialog")
    public DialogDto save(@RequestBody final DialogDto DialogDto) {
        return dialogService.save(DialogDto);
    }
}
