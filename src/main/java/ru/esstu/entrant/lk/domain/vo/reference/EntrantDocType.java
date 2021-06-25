package ru.esstu.entrant.lk.domain.vo.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantDocType {
    private int docTypeId;
    private String docTypeName;
    private int fisId;
}
