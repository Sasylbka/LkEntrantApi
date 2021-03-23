package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfo {
    private String id;
    private String education;
    private String year_of_finished;
    private String document_of_education;
    private String document_of_education_serial_number;
    private String place_of_finished;
    private String date_of_finished;
    private String studied_language;
    private String if_choosen_level_of_education_first;
}
