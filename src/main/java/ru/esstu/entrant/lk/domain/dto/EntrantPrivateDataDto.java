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
    private String family_name;
    private String patronymic;
    private String gender;
    private String date_of_birth;
    private String city_of_birth;
    private String region_of_birth;
}