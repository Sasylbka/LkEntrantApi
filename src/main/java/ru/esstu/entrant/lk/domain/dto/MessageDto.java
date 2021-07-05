package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private int id;
    private String role;
    private int dialogId;
    private int senderId;
    private String sender;
    private String message;
    private Date date;
}
