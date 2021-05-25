package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.QuestionnaireDto;
import ru.esstu.entrant.lk.domain.mappers.QuestionnaireMapper;
import ru.esstu.entrant.lk.repositories.QuestionnaireRepository;

import java.util.List;

@Service
@Slf4j
public class QuestionnaireService {
    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionnaireMapper questionnaireMapper;
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository,
                         QuestionnaireMapper questionnaireMapper) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionnaireMapper = questionnaireMapper;
    }
    public List<QuestionnaireDto> getQuestionnaire() {
        List<QuestionnaireDto> temp = questionnaireMapper.toDtos(questionnaireRepository.getQuestionnaire());
        return temp;
    }
}
