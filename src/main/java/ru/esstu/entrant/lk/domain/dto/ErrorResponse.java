package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ответ с описанием ошибки.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    /**
     * Описание ошибки.
     */
    private String message;
}
