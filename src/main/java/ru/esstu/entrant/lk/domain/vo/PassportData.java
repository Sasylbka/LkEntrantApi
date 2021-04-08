package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportData {
    private String id;
    private String serialNumber;
    private String placeOfIssue;
    private String codeOfSubdivision;
    private String dateOfIssue;
}