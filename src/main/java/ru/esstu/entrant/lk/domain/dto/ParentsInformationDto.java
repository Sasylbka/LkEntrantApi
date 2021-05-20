package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentsInformationDto {
    private int id;
    private int entrantId;
    private String fatherMobileNumber;
    private String fatherName;
    private String fatherSecondName;
    private String fatherPatronymic;
    private String placeOfFatherJob;
    private String motherMobileNumber;
    private String motherName;
    private String motherSecondName;
    private String motherPatronymic;
    private String placeOfMotherJob;
    private String additionalPhoneNumber;
}
