package ru.esstu.entrant.lk.domain.vo.forpdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfoForPDF {
    private Integer eduInstTypeId;
    private Integer endYear;
    private Integer eduDocTypeId;
    private String docSeries;
    private String docNumber;
    private Integer regionId;
    private Integer graduationPlaceId;
    private String city;
    private String eduInstName;
    private Date docDate;
    private Integer langId;
}
