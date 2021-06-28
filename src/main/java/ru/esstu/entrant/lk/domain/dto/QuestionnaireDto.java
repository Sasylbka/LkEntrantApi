package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Contract;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionnaireDto {
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
    private Boolean accelerated;
    private String email;
    private String mobileNumber;

}
