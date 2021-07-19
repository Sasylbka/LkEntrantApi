package ru.esstu.entrant.lk.domain.vo.forpdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitInformationForPDF {
    private int benefitHaving;
    private int militaryStatus;
    private boolean needsHostel;
}
