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

    public DialogService(DialogRepository dialogRepository,
                            DialogMapper dialogMapper) {
        this.dialogRepository = dialogRepository;
        this.dialogMapper = dialogMapper;
    }


    public List<DialogDto> getModeratorDialog(final int id) {
        List<DialogDto> temp = dialogMapper.toDtos(dialogRepository.getModeratorDialog(id));
        if(temp.size()==0){
            DialogDto dialogDto = new DialogDto(0,0,0);
            temp.add(dialogDto);
            return temp;
        }
        return temp;
    }
    public List<DialogDto> getEntrantDialog(final int id) {

        List<DialogDto> temp =dialogMapper.toDtos(dialogRepository.getEntrantDialog(id));
        return temp;
    }
    public DialogDto save(final DialogDto dialogDto) {
        Dialog entity= dialogMapper.toVO(dialogDto);
        dialogRepository.save(entity);
        return dialogMapper.toDto(entity);
    }
}
