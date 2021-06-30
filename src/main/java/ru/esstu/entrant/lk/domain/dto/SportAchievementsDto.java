package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportAchievementsDto {
    private int id;
    private int entrantId;
    private String documentOfSportVictories;
    private String documentOfSportVictoriesSerialNumber;
    private String issuedBy;
    private Date dataOfIssued;
}
