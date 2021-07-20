package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.QuestionnaireDto;
import ru.esstu.entrant.lk.domain.mappers.QuestionnaireMapper;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;
import ru.esstu.entrant.lk.domain.vo.Consent;
import ru.esstu.entrant.lk.repositories.AdmissionInfoRepository;
import ru.esstu.entrant.lk.repositories.ConsentRepository;
import ru.esstu.entrant.lk.repositories.QuestionnaireRepository;
import ru.esstu.entrant.lk.repositories.reference.SpecialityRefRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class QuestionnaireService {
    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionnaireMapper questionnaireMapper;
    private final AccessService accessService;
    private final AdmissionInfoRepository admissionInfoRepository;
    private final SpecialityRefRepository specialityRefRepository;
    private final ConsentRepository consentRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository,
                                QuestionnaireMapper questionnaireMapper,
                                AdmissionInfoRepository admissionInfoRepository,
                                SpecialityRefRepository specialityRefRepository,
                                AccessService accessService, ConsentRepository consentRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionnaireMapper = questionnaireMapper;
        this.accessService = accessService;
        this.admissionInfoRepository = admissionInfoRepository;
        this.specialityRefRepository = specialityRefRepository;
        this.consentRepository = consentRepository;
    }

    public Boolean checkAccel(QuestionnaireDto questionnaireDto) {//Проверка на ускоренное обучение
        List<AdmissionInfo> aiList = admissionInfoRepository.getAdmissionInfos(questionnaireDto.getId());
        if (aiList.size() == 0) {
            return null;
        }
        for (int i = 0; i < aiList.size(); i++) {
            if (specialityRefRepository.getFacultyId(Long.parseLong(aiList.get(i).getDirection())) == 13) {
                return true;
            }
        }
        return false;
    }


    public List<QuestionnaireDto> getQuestionnaire() {
        List<QuestionnaireDto> temp = questionnaireMapper.toDtos(questionnaireRepository.getQuestionnaire());
        List<Integer> list = new ArrayList<Integer>();
        list.add(temp.get(0).getId());
        List<QuestionnaireDto> temp1 = new ArrayList<QuestionnaireDto>();
        List <AdmissionInfo> admissionInfoList = admissionInfoRepository.selectAll();
        List <Consent> consents= consentRepository.getConsents();
        temp1.add(temp.get(0));
        for (int i = 1; i < temp.size(); i++) {
            if (!list.contains(temp.get(i).getId())) {
                list.add(temp.get(i).getId());
                temp1.add(temp.get(i));
            }
        }
        for (int i = 0; i < temp1.size(); i++) {
            for (AdmissionInfo yoba:admissionInfoList) {
                if(yoba.getEntrantId()==temp1.get(i).getEntrantId()) {
                    if (yoba.isContract()) {
                        temp1.get(i).setContract("true");
                    }
                    if (yoba.isConsentBudget() || yoba.isConsentTarget() || yoba.isConsentQuote()) {
                        temp1.get(i).setConsent(true);
                        temp1.get(i).setDirection(yoba.getDirection());
                    }
                }
            }
            temp1.get(i).setAccelerated(checkAccel(temp1.get(i)));
            if(temp1.get(i).getAccelerated()==null){
                temp1.get(i).setAccelerated(false);
            }
        }
        return temp1;
    }
}
