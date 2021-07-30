package ru.esstu.entrant.lk.domain.dto.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduDocTypeDto {
    private int eduDocTypeId;
    private String eduDocTypeName;
    private Boolean forPostgraduate;
}
