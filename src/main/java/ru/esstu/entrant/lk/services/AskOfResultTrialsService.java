package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.dto.AskOfResultTrialsDto;
import ru.esstu.entrant.lk.domain.mappers.AskOfResultTrialsMapper;
import ru.esstu.entrant.lk.domain.vo.AskOfResultTrials;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.repositories.AskOfResultTrialsRepository;

@Service
@Slf4j
public class AskOfResultTrialsService {

    private final AskOfResultTrialsRepository askOfResultTrialsRepository;
    private final AskOfResultTrialsMapper askOfResultTrialsMapper;

    public AskOfResultTrialsService(AskOfResultTrialsRepository askOfResultTrialsRepository,
                                    AskOfResultTrialsMapper askOfResultTrialsMapper) {
        this.askOfResultTrialsRepository = askOfResultTrialsRepository;
        this.askOfResultTrialsMapper = askOfResultTrialsMapper;
    }


    public AskOfResultTrialsDto getAskOfResultTrials(final String id) {
        return askOfResultTrialsMapper.toDto(askOfResultTrialsRepository.getAskOfResultTrials(id));
//        return new TestTableDto(1, "NTCN");
    }
    public AskOfResultTrials postAskOfResultTrials(final String id, final String result) {
        return askOfResultTrialsMapper.toVO(askOfResultTrialsRepository.postAskOfResultTrials(id,result));
    }
}