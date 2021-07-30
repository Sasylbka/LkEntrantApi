package ru.esstu.entrant.lk.domain.vo.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduDocType {
    private int eduDocTypeId;
    private String eduDocTypeName;
    private Boolean forPostgraduate;
}
