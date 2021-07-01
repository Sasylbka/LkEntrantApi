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


    public List<DialogDto> getModeratorDialog(final int id, final String role) {
        accessService.commonAccessCheck(id);
        List<Dialog> list = dialogRepository.getModeratorDialog(role);
        for (Dialog entity : list) {
            if (entity.getLastMessage() > entity.getLastReadModeratorMessage()) {
                entity.setHaveUnreadModeratorMessage(true);
            } else {
                entity.setHaveUnreadModeratorMessage(false);
            }
        }
        return dialogMapper.toDtos(list);
    }

    public List<DialogDto> getEntrantDialog(final int id) {
        accessService.commonAccessCheck(id);
        List<Dialog> list = dialogRepository.getEntrantDialog(id);
        for (Dialog entity : list) {
            if (entity.getLastMessage() > entity.getLastReadModeratorMessage()) {
                entity.setHaveUnreadEntrantMessage(true);
            } else {
                entity.setHaveUnreadEntrantMessage(false);
            }
        }
        return dialogMapper.toDtos(list);
    }

    public DialogDto save(final DialogDto dialogDto) {
        accessService.commonAccessCheck(dialogDto.getEntrantId());
        Dialog entity = dialogMapper.toVO(dialogDto);
        dialogRepository.save(entity);
        return dialogMapper.toDto(entity);
    }

    public void update(final int dialogId, final String role, final int id) {
        Dialog dialog = dialogRepository.getOne(dialogId, role);
        dialogRepository.update(dialogId, role, id, dialog.getEntrantId());
    }

    public void updateLRMM(final int dialogId, final String role, final int id) {//последнего прочитанного сообщения модером(любым).
        Dialog dialog = dialogRepository.getOne(dialogId, role);
        dialogRepository.updateLastReadModeratorMessage(dialogId, role, id, dialog.getEntrantId());
    }

    public void updateLREM(final int dialogId, final String role, final int id) {//последнего прочитанного сообщения энтрантом
        Dialog dialog = dialogRepository.getOne(dialogId, role);
        dialogRepository.updateLastReadEntrantMessage(dialogId, role, id, dialog.getEntrantId());
    }
/*
    public List<DialogDto> getUnreadModeratorMessage(final String role) {//Есть ли непрочитанные у модератора

    }

    public List<DialogDto> getUnreadEntrantMessage(final int entrantId) {//Есть ли непрочитанные у entrant-a

    }
*/
    public Dialog getEntrantDialog(final int dialogId, final String role) {
        return dialogRepository.getOne(dialogId, role);
    }

}
