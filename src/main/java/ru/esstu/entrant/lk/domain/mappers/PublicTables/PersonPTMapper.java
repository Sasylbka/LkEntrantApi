package ru.esstu.entrant.lk.domain.mappers.PublicTables;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.PublicTables.PersonDto;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class PersonPTMapper {
    public PersonDto toDto(Person vo) {
        if (vo == null) {
            return null;
        }
        return new PersonDto(
                vo.getPersonId()
        );
    }
    public Person toVO(PersonDto dto) {
        if (dto == null) {
            return null;
        }
        return new Person(
                dto.getPersonId()
        );
    }
}
