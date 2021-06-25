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
    private String admittanceCategory;
    private boolean budget;//выбрал бюджет
    private boolean contract;//договор
    private boolean targetedTraining;//выбрал целевое
    private boolean quota;//выбрал льготы
    private boolean consentBudget;//согласен на зачисление на бюджет
    private boolean consentTarget;//согласен на зачисление на целевое
    private boolean consentQuote;//согласен на зачисление на льготное
}
