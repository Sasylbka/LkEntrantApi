package ru.esstu.entrant.lk.domain.vo.forpdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionInfoForPDF {
    private int direction;
    private boolean original_edu_document;
    private Date registered_on;
    private String directionName;
    private String levelOfEducation;
    private String eduForm;
}
