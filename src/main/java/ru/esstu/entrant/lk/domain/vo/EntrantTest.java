package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantTest {
    private String username;
    private String passwordText;
    private Date examDate;
    private String discName;
    private Date startTestTime;
    private Boolean enabled;
    private String ball;//пока не надо получать
    private String place;//пока не надо получать
}
