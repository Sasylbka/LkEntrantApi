package ru.esstu.entrant.lk.domain.vo.forpdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfoForPDF {
    private Integer education;
    private Integer yearOfFinished;
    private String documentOfEducation;
    private String serial;
    private String number;
    private Integer regionOfFinished;
    private Integer districtOfFinished;
    private String city;
    private String placeOfFinished;
    private Date dateOfFinished;
    private Integer studiedLanguage;
}
