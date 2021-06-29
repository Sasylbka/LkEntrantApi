package ru.esstu.entrant.lk.web.PublicTables;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.PublicTables.PersonDto;
import ru.esstu.entrant.lk.services.AcceptAnketaService;
import ru.esstu.entrant.lk.services.PublicTables.PersonPTService;
@RestController
@Slf4j
public class PersonPTController {
    private final PersonPTService personPTService;
    PersonPTController(PersonPTService personPTService){
        this.personPTService=personPTService;
    }
    @RequestMapping(method = RequestMethod.GET,path = "/public/person")
    public PersonDto get(final String activate_id){
        return personPTService.getPerson(activate_id);
    }
}
