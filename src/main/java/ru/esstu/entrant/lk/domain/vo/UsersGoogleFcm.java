package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersGoogleFcm {
    private int id;
    private String userId;
    private String platform;
    private String token;
    private Date createdAt;
    private Date modifiedAt;
}
