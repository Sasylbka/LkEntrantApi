package ru.esstu.entrant.lk.domain.dto.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OlympiadDto {
    private int OlimpiadId;
    private String OlimpiadNumber;
    private String OlimpiadName;
}
