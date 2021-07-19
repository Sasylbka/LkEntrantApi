package ru.esstu.entrant.lk.domain.vo.forpdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalInformationForPDF {
    private Integer regionId;
    private Integer districtId;
    private String city;
    private String street;
    private String buildingNum;
    private String flatNum;
    private String index;
    private Integer addressTypeId;
}
