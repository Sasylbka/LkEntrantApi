package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.DialogDto;
import ru.esstu.entrant.lk.domain.dto.DialogDto;
import ru.esstu.entrant.lk.domain.dto.MessageDto;
import ru.esstu.entrant.lk.domain.mappers.DialogMapper;
import ru.esstu.entrant.lk.domain.vo.Dialog;
import ru.esstu.entrant.lk.repositories.DialogRepository;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class DialogService {
    private final DialogRepository dialogRepository;
    private final DialogMapper dialogMapper;
    private final AccessService accessService;

    public DialogService(DialogRepository dialogRepository,
                            DialogMapper dialogMapper,
                         AccessService accessService) {
        this.dialogRepository = dialogRepository;
        this.dialogMapper = dialogMapper;
        this.accessService = accessService;
    }


    public List<DialogDto> getModeratorDialog(final int id,final String role) {
        //accessService.commonAccessCheck(id);
        return dialogMapper.toDtos(dialogRepository.getModeratorDialog(role));
    }
    public List<DialogDto> getEntrantDialog(final int id) {
        //accessService.commonAccessCheck(id);
        return dialogMapper.toDtos(dialogRepository.getEntrantDialog(id));
    }
    public DialogDto save(final DialogDto dialogDto) {
        //accessService.commonAccessCheck(dialogDto.getEntrantId());
        Dialog entity= dialogMapper.toVO(dialogDto);
        dialogRepository.save(entity);
        return dialogMapper.toDto(entity);
    }
}
