package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionInfoDto {
    private int id;
    private int entrantId;
    private String levelOfEducation;
    private String firstDirection;
    private String secondDirection;
    private String thirdDirection;
}
