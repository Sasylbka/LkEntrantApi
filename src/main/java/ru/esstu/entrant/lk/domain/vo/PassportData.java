package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportData {
    private int id;
    private int entrantId;
    private String serialNumber;
    private String placeOfIssue;
    private String codeOfSubdivision;
    private Date dateOfIssue;
}