package ru.esstu.entrant.lk.domain.dto.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitKindDto {
    private int benefitKindId;
    private String benefitKindName;
}
