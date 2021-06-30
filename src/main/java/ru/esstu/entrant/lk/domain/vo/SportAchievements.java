package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportAchievements {
    private int id;
    private int entrantId;
    private String documentOfSportVictories;
    private String documentOfSportVictoriesSerialNumber;
    private String issuedBy;
    private Date dataOfIssued;
}
