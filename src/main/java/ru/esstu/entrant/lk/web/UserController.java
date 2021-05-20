package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.UserDto;
import ru.esstu.entrant.lk.services.UserService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class UserController {

    /**
     * Сервис.
     */
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user/currentUser")
    public UserDto getCurrentUser() {
        return userService.getCurrentUser();
    }
}
