package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.QuestionnaireDto;
import ru.esstu.entrant.lk.services.QuestionnaireService;

import java.util.List;

@RestController
@Slf4j
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/questionnaire")
    public List<QuestionnaireDto> get() {
        return questionnaireService.getQuestionnaire();
    }
}
