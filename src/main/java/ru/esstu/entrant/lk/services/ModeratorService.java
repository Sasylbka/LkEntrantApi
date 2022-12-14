package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.geolatte.geom.M;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.ModeratorDto;
import ru.esstu.entrant.lk.domain.mappers.ModeratorMapper;
import ru.esstu.entrant.lk.domain.vo.Moderator;
import ru.esstu.entrant.lk.exceptions.PermissionDeniedException;
import ru.esstu.entrant.lk.repositories.ModeratorRepository;
import ru.esstu.entrant.lk.utils.UserUtils;

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
        if (!UserUtils.hasCommonAccess(id,
                getOrCreateModeratorByKeycloakGuid(UserUtils.getCurrentUserKeycloakGuid()).getId())) {
            throw new PermissionDeniedException(
                    "Нет прав доступа. ИД пользователя : " + id);
        }
        ModeratorDto temp = moderatorMapper.toDto(moderatorRepository.getModerator(id));
        if(temp==null){
            temp= new ModeratorDto();
            return temp;
        }
        return temp;
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
