package ru.esstu.entrant.lk.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private int id;
    private int dialogId;
    private String message;
    private Date date;
}
