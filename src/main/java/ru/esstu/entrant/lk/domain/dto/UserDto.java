package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.esstu.entrant.lk.domain.enums.UserRoleEnum;

/**
 * Пользователь.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    /**
     * ИД.
     */
    private int id;
    /**
     * Тип пользователя.
     */
    private UserRoleEnum userRole;
}
