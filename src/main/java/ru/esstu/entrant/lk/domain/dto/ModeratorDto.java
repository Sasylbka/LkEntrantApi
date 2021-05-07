package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeratorDto {
    private int id;
    private String login;
    private String password;
    private String first_name;
    private String second_name;
    private String patronymic;
}
