package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentsInformation {
    private int id;
    private int entrantId;
    private String fatherMobileNumber;
    private String fatherName;
    private String fatherSecondName;
    private String fatherPatronymic;
    private String placeOfFatherJob;
    private String fatherEmail;
    private String motherMobileNumber;
    private String motherName;
    private String motherSecondName;
    private String motherPatronymic;
    private String placeOfMotherJob;
    private String motherEmail;
    private String additionalPhoneNumber;
}
