package ru.esstu.entrant.lk.domain.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String dateOfBirth;
    private String cityOfBirth;
    private String regionOfBirth;
    private String Snills;
}