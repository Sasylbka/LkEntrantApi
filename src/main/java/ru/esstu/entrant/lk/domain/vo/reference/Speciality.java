package ru.esstu.entrant.lk.domain.vo.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speciality {
    private long specId;
    private int eduFormId;
    private int eduLvlId;
    private String specialityName;
    private String specCode;
}
