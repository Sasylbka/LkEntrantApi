package ru.esstu.entrant.lk.domain.vo.forpdf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantPrivateDataForPDF {
    private String surname;
    private String name;
    private String patronymic;
    private Boolean male;
    private Date birthdate;
    private String birthRegion;
    private String birthCity;
    private String snils;
    private Integer militaryStatusId;//военнообязанный
    private Boolean needHostel;//нужно общежитие
}