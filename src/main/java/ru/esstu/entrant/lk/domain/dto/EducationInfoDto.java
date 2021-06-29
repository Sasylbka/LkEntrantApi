package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfoDto {
    private int id;
    private int entrantId;
    private String education;
    private String yearOfFinished;
    private String documentOfEducation;
    private String documentOfEducationSerialNumber;
    private String city;
    private int regionOfFinished;
    private int districtOfFinished;
    private String placeOfFinished;
    private Date dateOfFinished;
    private String studiedLanguage;
    private String ifChoosenLevelOfEducationFirst;
    private String entranceTest;
}
