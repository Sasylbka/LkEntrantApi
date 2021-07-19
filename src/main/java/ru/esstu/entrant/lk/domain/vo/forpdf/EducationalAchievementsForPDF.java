package ru.esstu.entrant.lk.domain.vo.forpdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationalAchievementsForPDF {
    private Integer medal;
    private Integer olympiadParticipation;
    private Integer sportQualification;
}
