package ru.esstu.entrant.lk.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsentDto {//История запросов
    private int id;
    private int entrantId;
    private int admissionInfoId;
    private String formOfFinancing;//бюджет, льготы, целевое
    private Date date;
    private String actionType;//add или cancel
}
