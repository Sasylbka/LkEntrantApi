package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionInfoDto {
    private int id;
    private int entrantId;
    private String levelOfEducation;
    private String direction;//id из справочника
    private boolean budget;//бюджет
    private boolean contract;//договор
    private boolean targetedTraining;//целевое
    private boolean quota;//квотники
    private boolean consent;//согласен на зачисление
}
