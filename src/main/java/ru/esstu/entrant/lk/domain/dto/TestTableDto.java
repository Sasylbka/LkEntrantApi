package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Тестовый дто.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestTableDto {
    /**
     * ИД.
     */
    private int id;
    /**
     * Текст.
     */
    private String testText;
}
