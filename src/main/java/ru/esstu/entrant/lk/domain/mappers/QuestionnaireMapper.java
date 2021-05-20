package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.QuestionnaireDto;
import ru.esstu.entrant.lk.domain.vo.Questionnaire;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class QuestionnaireMapper{
    public QuestionnaireDto toDto(Questionnaire vo) {
        if (vo == null) {
            return null;
        }
        return new QuestionnaireDto(
                vo.getId(),
                vo.getEntrantId(),
                vo.getName(),
                vo.getFamilyName(),
                vo.getPatronymic(),
                vo.getLevelOfEducation(),
                vo.getDateOfCreation(),
                vo.getDateOfSend(),
                vo.getDateOfAnswer(),
                vo.getStatus(),
                vo.getContract()
        );
    }
    public Questionnaire toVO(QuestionnaireDto dto) {
        if (dto == null) {
            return null;
        }
        return new Questionnaire(
                dto.getId(),
                dto.getEntrantId(),
                dto.getName(),
                dto.getFamilyName(),
                dto.getPatronymic(),
                dto.getLevelOfEducation(),
                dto.getDateOfCreation(),
                dto.getDateOfSend(),
                dto.getDateOfAnswer(),
                dto.getStatus(),
                dto.getContract()
        );
    }
    public List<QuestionnaireDto> toDtos (List<Questionnaire> vos) {
        List<QuestionnaireDto> list = new ArrayList<>();
        for (Questionnaire vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
