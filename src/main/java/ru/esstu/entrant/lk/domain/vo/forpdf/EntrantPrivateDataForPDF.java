package ru.esstu.entrant.lk.domain.vo.forpdf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrantPrivateDataForPDF {
    private String familyName;
    private String name;
    private String patronymic;
    private String gender;
    private Date dateOfBirth;
    private String cityOfBirth;
    private String regionOfBirth;
    private String snills;
    private Integer reservist;//военнообязанный
    private Boolean needsHostel;//нужно общежитие
}