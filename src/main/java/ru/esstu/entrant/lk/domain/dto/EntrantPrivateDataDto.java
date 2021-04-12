package ru.esstu.entrant.lk.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantPrivateDataDto {
    private String id;
    private String name;
    private String familyName;
    private String patronymic;
    private String gender;
    private String dateOfBirth;
    private String cityOfBirth;
    private String regionOfBirth;
}
