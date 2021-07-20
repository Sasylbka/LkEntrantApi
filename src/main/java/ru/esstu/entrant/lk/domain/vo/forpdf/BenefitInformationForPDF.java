package ru.esstu.entrant.lk.domain.vo.forpdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitInformationForPDF {
    private Integer docTypeId;
    private int militaryStatusId;
    private boolean needHostel;
}
