package ru.esstu.entrant.lk.domain.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consent {//История запросов
    private int id;
    private int entrantId;
    private int admissionInfoId;
    private String formOfFinancing;//бюджет, льготы, целевое
    private Date date;
    private String actionType;
}
