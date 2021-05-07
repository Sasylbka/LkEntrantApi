package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.DialogDto;
import ru.esstu.entrant.lk.domain.dto.DialogDto;
import ru.esstu.entrant.lk.domain.mappers.DialogMapper;
import ru.esstu.entrant.lk.domain.vo.Dialog;
import ru.esstu.entrant.lk.repositories.DialogRepository;
@Service
@Slf4j
public class DialogService {
    private final DialogRepository dialogRepository;
    private final DialogMapper dialogMapper;

    public DialogService(DialogRepository dialogRepository,
                            DialogMapper dialogMapper) {
        this.dialogRepository = dialogRepository;
        this.dialogMapper = dialogMapper;
    }


    public DialogDto getModeratorDialog(final int id) {
        return dialogMapper.toDto(dialogRepository.getModeratorDialog(id));
    }
    public DialogDto getEntrantDialog(final int id) {
        return dialogMapper.toDto(dialogRepository.getEntrantDialog(id));
    }
    public DialogDto save(final DialogDto dialogDto) {
        Dialog entity= dialogMapper.toVO(dialogDto);
        dialogRepository.save(entity);
        return dialogMapper.toDto(entity);
    }
}
