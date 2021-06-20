package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitInformation {
    private int id;
    private int entrantId;
    private String reasonForTheBenefit;
    private String documentForTheBenefit;
    private String serialNumberOfDocumentForTheBenefit;
    private String issuedBy;
    private Date dataOfIssued;
    private Boolean benefitChecked;
}
