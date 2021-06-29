package ru.esstu.entrant.lk.services.PublicTables;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.PublicTables.PersonDto;
import ru.esstu.entrant.lk.domain.mappers.PublicTables.PersonPTMapper;
import ru.esstu.entrant.lk.repositories.PublicTables.PersonPTRepository;

import java.util.List;
@Service
@Slf4j
public class PersonPTService { private final PersonPTRepository PersonPTRepository;
    private final PersonPTMapper PersonPTMapper;

    public PersonPTService(PersonPTRepository PersonPTRepository,
                                 PersonPTMapper PersonPTMapper) {
        this.PersonPTRepository = PersonPTRepository;
        this.PersonPTMapper = PersonPTMapper;
    }

    public PersonDto getPerson(String activate_id) {
        return PersonPTMapper.toDto(PersonPTRepository.getPerson(activate_id));
    }
}
