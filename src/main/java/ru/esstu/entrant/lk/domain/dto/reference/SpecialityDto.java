package ru.esstu.entrant.lk.domain.dto.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialityDto {
    private long specId;
    private int eduFormId;
    private int eduLevelId;
    private String specialityName;
    private String specCode;
    private int numberBudget;
    private int numberPaid;
    private int numberTarget;
    private int numberBenefit;
    private int facultyId;
    private Boolean accelEdu;//Ускоренное обучение
}
