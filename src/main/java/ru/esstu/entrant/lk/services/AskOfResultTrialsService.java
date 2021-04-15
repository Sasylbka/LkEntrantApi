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
    }
    public AskOfResultTrials postAskOfResultTrials(final AskOfResultTrialsDto askOfResultTrialsDto) {
        return askOfResultTrialsMapper.toVO(askOfResultTrialsRepository.postAskOfResultTrials(askOfResultTrialsMapper.toVO(askOfResultTrialsDto)));
    }
}