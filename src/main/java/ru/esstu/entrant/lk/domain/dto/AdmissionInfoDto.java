package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionInfoDto {
    private String id;
    private String level_of_education;
    private String first_direction;
    private String second_direction;
    private String third_direction;
}
