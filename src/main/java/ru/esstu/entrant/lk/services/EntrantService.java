package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.EntrantDto;
import ru.esstu.entrant.lk.domain.mappers.EntrantMapper;
import ru.esstu.entrant.lk.domain.vo.Entrant;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;
import ru.esstu.entrant.lk.domain.vo.PublicTables.EntrantForKeycloak;
import ru.esstu.entrant.lk.domain.vo.PublicTables.EntrantPerson;
import ru.esstu.entrant.lk.exceptions.PermissionDeniedException;
import ru.esstu.entrant.lk.repositories.EntrantPrivateDataRepository;
import ru.esstu.entrant.lk.repositories.EntrantRepository;
import ru.esstu.entrant.lk.repositories.PublicTables.EntrantPersonPTRepository;
import ru.esstu.entrant.lk.utils.UserUtils;

@Service
@Slf4j
public class EntrantService {

    private final EntrantRepository entrantRepository;
    private final EntrantMapper entrantMapper;
    private final EntrantPersonPTRepository entrantPersonPTRepository;
    private final EntrantPrivateDataRepository entrantPrivateDataRepository;
    public EntrantService(EntrantRepository entrantRepository,
                          EntrantMapper entrantMapper, EntrantPersonPTRepository entrantPersonPTRepository, EntrantPrivateDataRepository entrantPrivateDataRepository) {
        this.entrantRepository = entrantRepository;
        this.entrantMapper = entrantMapper;
        this.entrantPersonPTRepository = entrantPersonPTRepository;

        this.entrantPrivateDataRepository = entrantPrivateDataRepository;
    }

    public EntrantDto getEntrant(final int id) {
        if (!UserUtils.hasCommonAccess(id,
                getOrCreateEntrantByKeycloakGuid(UserUtils.getCurrentUserKeycloakGuid()).getId())) {
            throw new PermissionDeniedException(
                    "Нет прав доступа. ИД пользователя : " + id);
        }
        EntrantDto temp = entrantMapper.toDto(entrantRepository.getEntrant(id));
        if (temp == null) {
            temp = new EntrantDto();
            return temp;
        }
        return temp;
    }

    public EntrantDto update(final EntrantDto entrantDto) {
        if (!UserUtils.hasCommonAccess(entrantDto.getId(),
                getOrCreateEntrantByKeycloakGuid(UserUtils.getCurrentUserKeycloakGuid()).getId())) {
            throw new PermissionDeniedException(
                    "Нет прав доступа. ИД пользователя : " + entrantDto.getId());
        }
        Entrant entity = entrantMapper.toVO(entrantDto);
        entrantRepository.update(entity);
        return entrantMapper.toDto(entity);
    }

    public Entrant updateStatus(final Entrant entrant) {
        Entrant entity = entrant;
        entrantRepository.updateStatus(entity);
        return entity;
    }

    public Entrant getOrCreateEntrantByKeycloakGuid(final String guid) {
        Entrant entrant = entrantRepository.getEntrantByKeycloakGuid(guid);
        if (entrant == null) {
            Entrant newEntrant = new Entrant();
            newEntrant.setKeycloakEmail(UserUtils.getCurrentEmail());
            newEntrant.setLogin("keycloak"); //пока не используется
            newEntrant.setPassword("keycloak"); //пока не используется
            entrantRepository.save(newEntrant, guid);
            return newEntrant;
        }
        return entrant;
    }

    public Entrant createKeycloakEntrant(final String guid, EntrantForKeycloak entrantForKeycloak) {
        Entrant entrant = entrantRepository.getEntrantByKeycloakGuid(guid);
        if (entrant == null) {
            Entrant newEntrant = new Entrant();
            newEntrant.setKeycloakEmail(entrantForKeycloak.getLoginForLk());
            newEntrant.setLogin("keycloak"); //пока не используется
            newEntrant.setPassword("keycloak"); //пока не используется
            newEntrant.setStatus("ACCEPTED_PERSONALLY");
            entrantRepository.save(newEntrant, guid);
            EntrantPerson entrantPerson = entrantPersonPTRepository.getEntrantPerson(guid);
            Entrant entrant1=entrantRepository.getEntrantByKeycloakGuid(guid);
            String male="male";
            if(!entrantPerson.isMale()) {
                male = "female";
            }
            EntrantPrivateData entrantPrivateData = new EntrantPrivateData(0,entrant1.getId(),
                    entrantPerson.getName(),entrantPerson.getSurname(),entrantPerson.getPatronymic(),
                    male,entrantPerson.getBirthdate(),entrantPerson.getBirthCity(),entrantPerson.getBirthRegion(),
                    entrantPerson.getSnils(),"no","no",false);
            entrantPrivateDataRepository.save(entrantPrivateData);
            return newEntrant;
        }
        return entrant;
    }
}
