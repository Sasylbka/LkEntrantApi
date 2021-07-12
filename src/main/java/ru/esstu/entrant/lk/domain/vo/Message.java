package ru.esstu.entrant.lk.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private int id;
    private String role;
    private int dialogId;
    private int senderId;
    private String sender;
    private String message;
    private Date date;
    private boolean attachments;
    private String filesGuid;
    private String fileName;
}
