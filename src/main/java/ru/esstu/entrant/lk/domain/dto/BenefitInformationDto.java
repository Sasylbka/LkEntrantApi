package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitInformationDto {

    private String id;
    private String reason_for_the_benefit;
    private String document_for_the_benefit;
    private String serial_number_document_for_the_benefit;
    private String issued_by;
    private String data_of_issued;
}
