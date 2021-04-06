package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionInfo {
    private String id;
    private String level_of_education;
    private String first_direction;
    private String second_direction;
    private String third_direction;
}
