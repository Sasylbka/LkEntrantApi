package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.services.reference.BenefitKindRefService;
import ru.esstu.entrant.lk.services.AcceptAnketaService;

@RestController
@Slf4j
public class AcceptAnketaController {
    private final AcceptAnketaService acceptAnketaService;
    AcceptAnketaController(AcceptAnketaService acceptAnketaService){
        this.acceptAnketaService=acceptAnketaService;
    }
    @RequestMapping(method = RequestMethod.POST,path = "/accpet")
    public void accept(final int entrantId,final int moderatorId){
        acceptAnketaService.AcceptAnketa(entrantId,moderatorId);
    }
}
