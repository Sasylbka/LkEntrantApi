package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangesDate {
    private int id;
    private int entrantId;
    private Date dateOfCreation;
    private Date dateOfSend;
    private Date dateOfAnswer;
    private String rejectionReason;

}
