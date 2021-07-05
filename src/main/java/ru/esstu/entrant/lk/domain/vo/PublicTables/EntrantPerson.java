package ru.esstu.entrant.lk.domain.vo.PublicTables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantPerson {
    private String name;
    private String surname;
    private String patronymic;
    private boolean male;
    private Date birthdate;
    private String snils;
    private String birthCity;
    private String birthRegion;
}
