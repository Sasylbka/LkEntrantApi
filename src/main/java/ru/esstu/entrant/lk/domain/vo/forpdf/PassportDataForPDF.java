package ru.esstu.entrant.lk.domain.vo.forpdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportDataForPDF {
    private String docSeries;
    private String docNumber;
    private String releasingOrgName;
    private String departmentCode;
    private Date releaseDate;
}