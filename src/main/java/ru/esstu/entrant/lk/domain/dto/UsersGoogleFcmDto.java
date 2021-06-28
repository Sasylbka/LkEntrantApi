package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersGoogleFcmDto {
    private int id;
    private String userId;
    private String platform;
    private String token;
    private Date createdAt;
    private Date modifiedAt;
}
