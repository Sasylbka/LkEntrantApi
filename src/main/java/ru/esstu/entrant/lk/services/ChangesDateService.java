package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.ChangesDateDto;
import ru.esstu.entrant.lk.domain.mappers.ChangesDateMapper;
import ru.esstu.entrant.lk.domain.vo.ChangesDate;
import ru.esstu.entrant.lk.repositories.ChangesDateRepository;
@Service
@Slf4j
public class ChangesDateService {
    private final ChangesDateRepository ChangesDateRepository;
    private final ChangesDateMapper ChangesDateMapper;
    private final AccessService accessService;

    public ChangesDateService(ChangesDateRepository ChangesDateRepository,
                              ChangesDateMapper ChangesDateMapper,
                              AccessService accessService) {
        this.ChangesDateRepository = ChangesDateRepository;
        this.ChangesDateMapper = ChangesDateMapper;
        this.accessService = accessService;
    }

    public ChangesDateDto getChangesDate(final int id) {
        accessService.commonAccessCheck(id);
        ChangesDateDto temp= ChangesDateMapper.toDto(ChangesDateRepository.getChangesDate(id));
        if(temp==null){
            temp=new ChangesDateDto();
            return temp;
        }
        return temp;
    }
    public ChangesDateDto save(final ChangesDateDto changesDateDto) {
        accessService.commonAccessCheck(changesDateDto.getEntrantId());
        ChangesDate entity = ChangesDateMapper.toVO(changesDateDto);
        ChangesDateRepository.save(entity);
        return ChangesDateMapper.toDto(entity);
    }
    public ChangesDateDto update(final ChangesDateDto changesDateDto) {
        accessService.commonAccessCheck(changesDateDto.getEntrantId());
        ChangesDate entity = ChangesDateMapper.toVO(changesDateDto);
        ChangesDateRepository.update(entity);
        return ChangesDateMapper.toDto(entity);
    }
}
