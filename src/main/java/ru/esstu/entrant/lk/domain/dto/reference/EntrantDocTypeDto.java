package ru.esstu.entrant.lk.domain.dto.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantDocTypeDto {
    private int docTypeId;
    private String docTypeName;
    private int fisId;
}
