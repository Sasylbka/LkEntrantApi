package ru.esstu.entrant.lk.domain.vo.forpdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalInformationForPDF {
    private Integer region;
    private Integer area;
    private String city;
    private String street;
    private String numberOfBuilding;
    private String numberOfApartments;
    private String index;
    private Integer type;
}
