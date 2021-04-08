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
    private String honorsDegree;
    private String olympiadParticipation;
    private String documentOfOlympiadVictories;
    private String documentOfOlympiadVictoriesSerialNumber;
    private String issuedBy;
    private String dataOfIssued;
    private String candidateMinimumsPassed;
}
