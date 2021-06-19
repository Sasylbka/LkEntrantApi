package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.UserDto;
import ru.esstu.entrant.lk.domain.enums.UserRoleEnum;
import ru.esstu.entrant.lk.domain.vo.Entrant;
import ru.esstu.entrant.lk.domain.vo.Moderator;
import ru.esstu.entrant.lk.utils.UserUtils;

@Service
@Slf4j
public class UserService {

    private final EntrantService entrantService;
    private final ModeratorService moderatorService;

    public UserService(EntrantService entrantService,
                       ModeratorService moderatorService) {
        this.entrantService = entrantService;
        this.moderatorService = moderatorService;
    }

    public UserDto getCurrentUser() {
        String keycloakUserGuid = UserUtils.getCurrentUserKeycloakGuid();
        if (UserUtils.hasRole(UserRoleEnum.ROLE_SELECTION_COMMIT.toString())) {
            Moderator moderator =
                    moderatorService.getOrCreateModeratorByKeycloakGuid(keycloakUserGuid);
            return new UserDto(moderator.getId(), UserRoleEnum.ROLE_SELECTION_COMMIT);
        }
        if (UserUtils.hasRole(UserRoleEnum.ROLE_ECONOMIC.toString())) {
            Moderator moderator =
                    moderatorService.getOrCreateModeratorByKeycloakGuid(keycloakUserGuid);
            return new UserDto(moderator.getId(), UserRoleEnum.ROLE_ECONOMIC);
        }
        Entrant entrant = entrantService.getOrCreateEntrantByKeycloakGuid(keycloakUserGuid);
        return new UserDto(entrant.getId(), UserRoleEnum.ROLE_ENTRANT);
    }
}
