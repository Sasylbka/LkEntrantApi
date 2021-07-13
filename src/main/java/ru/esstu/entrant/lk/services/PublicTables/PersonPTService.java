package ru.esstu.entrant.lk.services.PublicTables;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.PublicTables.PersonDto;
import ru.esstu.entrant.lk.domain.mappers.PublicTables.PersonPTMapper;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;
import ru.esstu.entrant.lk.repositories.PublicTables.PersonPTRepository;
import ru.esstu.entrant.lk.utils.UserUtils;

import java.util.List;
@Service
@Slf4j
public class PersonPTService { private final PersonPTRepository personPTRepository;
    private final PersonPTMapper personPTMapper;

    public PersonPTService(PersonPTRepository personPTRepository,
                                 PersonPTMapper personPTMapper) {
        this.personPTRepository = personPTRepository;
        this.personPTMapper = personPTMapper;
    }

    public PersonDto getPerson() {
        Person person=personPTRepository.getPerson(UserUtils.getCurrentUserKeycloakGuid());
        return personPTMapper.toDto(personPTRepository.getPerson(person.getPersonId()));
    }
}
