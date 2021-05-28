package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.exceptions.PermissionDeniedException;
import ru.esstu.entrant.lk.utils.UserUtils;

@Service
@Slf4j
public class AccessService {

    private final UserService userService;

    public AccessService(UserService userService) {
        this.userService = userService;
    }

    public void commonAccessCheck(int entityEntrantId){
        if (!UserUtils.hasCommonAccess(entityEntrantId, userService.getCurrentUser().getId())) {
            throw new PermissionDeniedException(
                    "Нет прав доступа. ИД пользователя : " + entityEntrantId);
        }
    }

}
