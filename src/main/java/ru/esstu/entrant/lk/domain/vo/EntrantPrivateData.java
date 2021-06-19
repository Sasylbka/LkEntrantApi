package ru.esstu.entrant.lk.domain.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantPrivateData {
    private int id;
    private int entrantId;
    private String name;
    private String familyName;
    private String patronymic;
    private String gender;
    private Date dateOfBirth;
    private String cityOfBirth;
    private String regionOfBirth;
    private String snills;
    private String reservist;//военнообязанный
    private String needsHostel;//нужно общежитие
    private boolean consentChecked;
}