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

    public ChangesDateService(ChangesDateRepository ChangesDateRepository,
                                     ChangesDateMapper ChangesDateMapper) {
        this.ChangesDateRepository = ChangesDateRepository;
        this.ChangesDateMapper = ChangesDateMapper;
    }

    public ChangesDateDto getChangesDate(final int id) {
        ChangesDateDto temp= ChangesDateMapper.toDto(ChangesDateRepository.getChangesDate(id));
        if(temp==null){
            temp=new ChangesDateDto();
            return temp;
        }
        return temp;
    }
    public ChangesDateDto save(final ChangesDateDto ChangesDateDto) {
        ChangesDate entity = ChangesDateMapper.toVO(ChangesDateDto);
        ChangesDateRepository.save(entity);
        return ChangesDateMapper.toDto(entity);
    }
    public ChangesDateDto update(final ChangesDateDto ChangesDateDto) {
        ChangesDate entity = ChangesDateMapper.toVO(ChangesDateDto);
        ChangesDateRepository.update(entity);
        return ChangesDateMapper.toDto(entity);
    }
}
