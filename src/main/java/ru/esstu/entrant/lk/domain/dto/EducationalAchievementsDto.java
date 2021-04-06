package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationalAchievementsDto {
    private String id;
    private String medal;
    private String honors_degree;
    private String olympiad_participation;
    private String document_of_olympiad_victories;
    private String document_of_olympiad_victories_serial_number;
    private String issued_by;
    private String data_of_issued;
    private String candidate_minimums_passed;
}
