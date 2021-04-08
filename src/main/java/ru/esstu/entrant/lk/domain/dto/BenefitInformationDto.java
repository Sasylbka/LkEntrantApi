package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitInformationDto {

    private String id;
    private String reasonForTheBenefit;
    private String documentForTheBenefit;
    private String serialNumberDocumentForTheBenefit;
    private String issuedBy;
    private String dataOfIssued;
}
