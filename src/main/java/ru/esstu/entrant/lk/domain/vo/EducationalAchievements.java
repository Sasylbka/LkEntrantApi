package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationalAchievements {
    private int id;
    private int entrantId;
    private String medal;
    private String honorsDegree;
    private String olympiadParticipation;
    private String documentOfOlympiadVictories;
    private String documentOfOlympiadVictoriesSerialNumber;
    private String issuedBy;
    private String dataOfIssued;
    private String candidateMinimumsPassed;
}
