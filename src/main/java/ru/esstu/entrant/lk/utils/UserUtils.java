package ru.esstu.entrant.lk.utils;

import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.esstu.entrant.lk.domain.enums.UserRoleEnum;

import java.util.Collection;

/**
 * Класс для работы с пользователями.
 */
public class UserUtils {

    public static String getCurrentUserKeycloakGuid() {
        return ((KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName();
    }

    public static Boolean hasRole(String role) {
        Collection<GrantedAuthority> authorities =
                (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return authorities.contains(new SimpleGrantedAuthority(role));
    }

    public static boolean hasCommonAccess(int currentUserId, int entityUserId) {
        if (isModerator()) return true;
        if (isEconomic()) return true;
        if (isEntrant() && currentUserId != 0 && currentUserId == entityUserId) return true;
        return false;
    }

    public static boolean isModerator() {
        if (hasRole(UserRoleEnum.ROLE_SELECTION_COMMIT.toString()))
            return true;
        return false;
    }

    public static boolean isEconomic() {
        if (hasRole(UserRoleEnum.ROLE_ECONOMIC.toString()))
            return true;
        return false;
    }

    public static boolean isEntrant() {
        if (hasRole(UserRoleEnum.ROLE_ENTRANT.toString())) return true;
        return false;
    }
}
