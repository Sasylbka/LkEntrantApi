package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.ModeratorDto;
import ru.esstu.entrant.lk.domain.mappers.ModeratorMapper;
import ru.esstu.entrant.lk.domain.vo.Moderator;
import ru.esstu.entrant.lk.repositories.ModeratorRepository;

@Service
@Slf4j
public class ModeratorService {
    private final ModeratorRepository moderatorRepository;
    private final ModeratorMapper moderatorMapper;

    public ModeratorService(ModeratorRepository moderatorRepository,
                            ModeratorMapper moderatorMapper) {
        this.moderatorRepository = moderatorRepository;
        this.moderatorMapper = moderatorMapper;
    }


    public ModeratorDto getModerator(final int id) {
        return moderatorMapper.toDto(moderatorRepository.getModerator(id));
    }

    public Moderator getOrCreateModeratorByKeycloakGuid(final String guid) {
        Moderator moderator = moderatorRepository.getModeratorByKeycloakGuid(guid);
        if (moderator == null) {
            Moderator newModerator = new Moderator();
            newModerator.setLogin("keycloak"); //пока не используется
            newModerator.setPassword("keycloak"); //пока не используется
            moderatorRepository.save(newModerator, guid);
            return newModerator;
        }
        return moderator;
    }
}
