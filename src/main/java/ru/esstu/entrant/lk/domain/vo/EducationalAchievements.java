package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date dataOfIssued;
    private String candidateMinimumsPassed;
}
