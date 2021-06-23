package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {
    private int id;
    private int entrantId;
    private String name;
    private String familyName;
    private String patronymic;
    private String levelOfEducation;
    private Date dateOfCreation;
    private Date dateOfSend;
    private Date dateOfAnswer;
    private String status;
    private String contract;
    private String email;
    private String mobileNumber;

}
