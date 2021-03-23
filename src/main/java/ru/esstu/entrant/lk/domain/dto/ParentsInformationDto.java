package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentsInformationDto {
    private String id;
    private String father_mobile_number;
    private String father_name;
    private String father_second_name;
    private String father_patronymic;
    private String place_of_father_job;
    private String mother_mobile_number;
    private String mother_name;
    private String mother_second_name;
    private String mother_patronymic;
    private String place_of_mother_job;
    private String additional_phone_number;
}
