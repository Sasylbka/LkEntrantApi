package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportDataDto {
    private String id;
    private String serialNumber;
    private String placeOfIssue;
    private String codeOfSubdivision;
    private String dateOfIssue;
}