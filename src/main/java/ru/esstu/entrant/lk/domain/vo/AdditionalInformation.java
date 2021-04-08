package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalInformation {
    private String id;
    private String index;
    private String region;
    private String area;
    private String city;
    private String street;
    private String numberOfBuilding;
    private String numberOfApartments;
}
