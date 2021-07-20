package ru.esstu.entrant.lk.domain.vo.forpdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionInfoForPDF {
    private int specId;
    private boolean originalEduDocument;
    private Date registeredOn;
    private String directionName;
    private String levelOfEducation;
    private String eduForm;
}
