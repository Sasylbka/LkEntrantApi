package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionInfo {
    private int id;
    private int entrantId;
    private String levelOfEducation;
    private String firstDirection;
    private String secondDirection;
    private String thirdDirection;
}
