package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.EntrantPrivateDataDto;
import ru.esstu.entrant.lk.domain.dto.EntrantPrivateDataDto;
import ru.esstu.entrant.lk.domain.mappers.EntrantPrivateDataMapper;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.repositories.EntrantPrivateDataRepository;

@Service
@Slf4j
public class EntrantPrivateDataService {

    private final EntrantPrivateDataRepository entrantPrivateDataRepository;
    private final EntrantPrivateDataMapper entrantPrivateDataMapper;

    public EntrantPrivateDataService(EntrantPrivateDataRepository entrantPrivateDataRepository,
                                     EntrantPrivateDataMapper entrantPrivateDataMapper) {
        this.entrantPrivateDataRepository = entrantPrivateDataRepository;
        this.entrantPrivateDataMapper = entrantPrivateDataMapper;
    }


    public EntrantPrivateDataDto getEntrantPrivateData(final int id) {
        return entrantPrivateDataMapper.toDto(entrantPrivateDataRepository.getEntrantPrivateData(id));
//        return new TestTableDto(1, "NTCN");
    }

    public EntrantPrivateDataDto save(final EntrantPrivateDataDto entrantPrivateDataDto) {
        EntrantPrivateData entity= entrantPrivateDataMapper.toVO(entrantPrivateDataDto);
        entrantPrivateDataRepository.save(entity);
        return entrantPrivateDataMapper.toDto(entity);
    }
}
