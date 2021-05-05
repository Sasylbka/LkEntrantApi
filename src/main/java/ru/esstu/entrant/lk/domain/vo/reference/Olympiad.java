package ru.esstu.entrant.lk.domain.vo.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Olympiad {
    private int OlimpiadId;
    private String OlimpiadNumber;
    private String OlimpiadName;
}
