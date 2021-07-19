package ru.esstu.entrant.lk.domain.vo.forpdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentsInformationForPDF {
    private String name;
    private String surname;
    private String patronymic;
    private String telephone;
}
