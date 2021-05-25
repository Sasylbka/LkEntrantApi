package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportData {
    private int id;
    private int entrantId;
    private String series;
    private String number;
    private String placeOfIssue;
    private String codeOfSubdivision;
    private Date dateOfIssue;
}