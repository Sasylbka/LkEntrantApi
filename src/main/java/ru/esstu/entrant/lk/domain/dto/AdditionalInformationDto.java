package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalInformationDto {
    private int id;
    private int entrantId;
    private String index;
    private String region;
    private String area;
    private String city;
    private String street;
    private String numberOfBuilding;
    private String numberOfApartments;
    private String type;
    private boolean coincides;//совпадает с местом жительства
}


