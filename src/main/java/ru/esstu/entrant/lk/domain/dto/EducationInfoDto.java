package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfoDto {
    private String id;
    private String education;
    private String yearOfFinished;
    private String documentOfEducation;
    private String documentOfEducationSerialNumber;
    private String placeOfFinished;
    private String dateOfFinished;
    private String studiedLanguage;
    private String ifChoosenLevelOfEducationFirst;
}
