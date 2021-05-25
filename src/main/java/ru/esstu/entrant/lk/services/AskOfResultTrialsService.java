package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.AskOfResultTrialsDto;
import ru.esstu.entrant.lk.domain.mappers.AskOfResultTrialsMapper;
import ru.esstu.entrant.lk.domain.vo.AskOfResultTrials;
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


    public AskOfResultTrialsDto getAskOfResultTrials(final int id) {
        AskOfResultTrialsDto temp = askOfResultTrialsMapper.toDto(askOfResultTrialsRepository.getAskOfResultTrials(id));
        if(temp==null){
            temp=new AskOfResultTrialsDto();
            return temp;
        }
        return temp;
    }
    public AskOfResultTrialsDto save(final AskOfResultTrialsDto askOfResultTrialsDto) {
        AskOfResultTrials entity= askOfResultTrialsMapper.toVO(askOfResultTrialsDto);
        askOfResultTrialsRepository.save(entity);
        return askOfResultTrialsMapper.toDto(entity);
    }

    public AskOfResultTrialsDto update(final AskOfResultTrialsDto askOfResultTrialsDto) {
        AskOfResultTrials entity= askOfResultTrialsMapper.toVO(askOfResultTrialsDto);
        askOfResultTrialsRepository.update(entity);
        return askOfResultTrialsMapper.toDto(entity);
    }
}