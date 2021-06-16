package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.QuestionnaireDto;
import ru.esstu.entrant.lk.domain.mappers.QuestionnaireMapper;
import ru.esstu.entrant.lk.repositories.QuestionnaireRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class QuestionnaireService {
    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionnaireMapper questionnaireMapper;
    private final AccessService accessService;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository,
                                QuestionnaireMapper questionnaireMapper,
                                AccessService accessService) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionnaireMapper = questionnaireMapper;
        this.accessService = accessService;
    }
    public List<QuestionnaireDto> getQuestionnaire() {
        List<QuestionnaireDto> temp = questionnaireMapper.toDtos(questionnaireRepository.getQuestionnaire());
        int k=0;
        List<Integer> list=new ArrayList<Integer>();
        list.add(temp.get(0).getId());
        List<QuestionnaireDto> temp1=new ArrayList<QuestionnaireDto>();
        temp1.add(temp.get(0));
        for(int i = 1;i<temp.size();i++){
            if(!list.contains(temp.get(i).getId())) {
                list.add(temp.get(i).getId());
                temp1.add(temp.get(i));
            }
        }
        return temp1;
    }
}
