package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestTable {
    /**
     * ИД.
     */
    private int id;
    /**
     * Текст.
     */
    private String testText;
}
