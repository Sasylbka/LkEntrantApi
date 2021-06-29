package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantDto {
    private int id;
    private String login;
    private String password;
    private String status;
    private String keycloakEmail;
}
