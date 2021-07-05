package ru.esstu.entrant.lk.services;


import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.vo.PublicTables.EntrantForKeycloak;
import ru.esstu.entrant.lk.exceptions.AlreadyHaveException;
import ru.esstu.entrant.lk.exceptions.InvalidObjectException;
import ru.esstu.entrant.lk.repositories.PublicTables.EntrantForKeycloakRepository;

import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CreateKeycloakUserService {
    private final EntrantForKeycloakRepository entrantForKeycloakRepository;
    private final EntrantService entrantService;

    public CreateKeycloakUserService(EntrantForKeycloakRepository entrantForKeycloakRepository, EntrantService entrantService) {
        this.entrantForKeycloakRepository = entrantForKeycloakRepository;
        this.entrantService = entrantService;
    }

    @Transactional
    public String createUser(EntrantForKeycloak entrantForKeycloak) {
        Keycloak keycloakBuilder = KeycloakBuilder.builder().serverUrl("https://sso.esstu.ru/auth")
                .clientId("admin-cli")
                .realm("esstu")
                .username("esstuadmin@esstu.ru")
                .password("esstuadmin312")
                .build();
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(entrantForKeycloak.getPasswordForLk());

        UserRepresentation user = new UserRepresentation();
        user.setUsername(entrantForKeycloak.getLoginForLk());
        user.setFirstName("name");
        user.setLastName("lastname");
        user.setEmail(entrantForKeycloak.getLoginForLk());
        user.setCredentials(Arrays.asList(credential));
        user.setEnabled(true);
        user.setRealmRoles(Arrays.asList("default-roles-esstu"));

        RealmResource realmResource = keycloakBuilder.realm("esstu");
        UsersResource usersResource = realmResource.users();
        Response result = null;
        String activate_id = null;
        try {
            result = usersResource.create(user);
            activate_id = result.getLocation().toString();
            activate_id = activate_id.replace("https://sso.esstu.ru/auth/admin/realms/esstu/users/", "");
        } catch (Exception e) {
            throw new AlreadyHaveException(e.getMessage());
        }

        if (result == null || result.getStatus() != 201) {
            throw new InvalidObjectException("Ошибка создания пользователя");
        }
        return activate_id;
    }

    @Scheduled(cron = "0 0 20 * * *")
    public void CreateUsers() {
        List<EntrantForKeycloak> list = entrantForKeycloakRepository.getEntrants();
        for (EntrantForKeycloak entrant : list) {
            String activate_id = createUser(entrant);
            if (activate_id != null) {
                entrantForKeycloakRepository.updateEntrant(activate_id, entrant.getEntrantId());
                entrantService.createKeycloakEntrant(activate_id, entrant);
            }
        }
    }

}
