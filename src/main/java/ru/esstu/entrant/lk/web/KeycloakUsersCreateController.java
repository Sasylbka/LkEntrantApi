package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.services.CreateKeycloakUserService;

@RestController
@Slf4j
public class KeycloakUsersCreateController {
    private final CreateKeycloakUserService createKeycloakUserService;

    public KeycloakUsersCreateController(CreateKeycloakUserService createKeycloakUserService) {
        this.createKeycloakUserService = createKeycloakUserService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/createKeycloakUsers")
    public void create() {
        createKeycloakUserService.CreateUsers();
    }
}
