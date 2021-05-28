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
    private final AccessService accessService;

    public EntrantPrivateDataService(EntrantPrivateDataRepository entrantPrivateDataRepository,
                                     EntrantPrivateDataMapper entrantPrivateDataMapper,
                                     UserService userService,
                                     AccessService accessService) {
        this.entrantPrivateDataRepository = entrantPrivateDataRepository;
        this.entrantPrivateDataMapper = entrantPrivateDataMapper;
        this.accessService = accessService;
    }


    public EntrantPrivateDataDto getEntrantPrivateData(final int id) {
        accessService.commonAccessCheck(id);
        EntrantPrivateDataDto temp = entrantPrivateDataMapper.toDto(entrantPrivateDataRepository.getEntrantPrivateData(id));
        if(temp==null){
            temp = new EntrantPrivateDataDto();
            return temp;
        }
        return temp;
    }

    public EntrantPrivateDataDto save(final EntrantPrivateDataDto entrantPrivateDataDto) {
        accessService.commonAccessCheck(entrantPrivateDataDto.getEntrantId());
        EntrantPrivateData entity= entrantPrivateDataMapper.toVO(entrantPrivateDataDto);
        entrantPrivateDataRepository.save(entity);
        return entrantPrivateDataMapper.toDto(entity);
    }

    public EntrantPrivateDataDto update(final EntrantPrivateDataDto entrantPrivateDataDto) {
        accessService.commonAccessCheck(entrantPrivateDataDto.getEntrantId());
        EntrantPrivateData entity = entrantPrivateDataMapper.toVO(entrantPrivateDataDto);
        entrantPrivateDataRepository.update(entity);
        return entrantPrivateDataMapper.toDto(entity);
    }
}
