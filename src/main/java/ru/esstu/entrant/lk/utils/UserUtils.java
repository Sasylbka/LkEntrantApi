package ru.esstu.entrant.lk.utils;

import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

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
}
