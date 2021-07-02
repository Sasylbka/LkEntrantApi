package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.async.NotificationAsync;
import ru.esstu.entrant.lk.domain.dto.MessageDto;
import ru.esstu.entrant.lk.domain.mappers.MessageMapper;
import ru.esstu.entrant.lk.domain.vo.Message;
import ru.esstu.entrant.lk.repositories.MessageRepository;
import ru.esstu.entrant.lk.utils.UserUtils;

import java.text.ParseException;
import java.util.List;


@Service
@Slf4j
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final DialogService dialogService;
    private final NotificationAsync notificationAsync;

    public MessageService(MessageRepository messageRepository,
                          MessageMapper messageMapper, DialogService dialogService,
                          NotificationAsync notificationAsync) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
        this.dialogService = dialogService;
        this.notificationAsync = notificationAsync;
    }


    public List<MessageDto> getMessage(final int id, final String role) {
        List<MessageDto> temp = messageMapper.toDtos(messageRepository.getMessage(id, role));
        if (temp != null && !temp.isEmpty()) {
            MessageDto mes = temp.get(temp.size() - 1);//Последнее сообщение
            if (UserUtils.isModerator() || UserUtils.isEconomic()) {
                dialogService.updateLRMM(mes.getDialogId(), mes.getRole(), mes.getId());
            } else if (UserUtils.isEntrant()) {
                dialogService.updateLREM(mes.getDialogId(), mes.getRole(), mes.getId());
            }
        }
        return temp;
    }

    public MessageDto save(final MessageDto messageDto) throws ParseException {
        Message entity = messageMapper.toVO(messageDto);
        messageRepository.save(entity);
        notificationAsync.sendNotificationMessageAsync(dialogService.getEntrantDialog(entity.getDialogId(), entity.getRole()), entity);
        dialogService.update(entity.getDialogId(), entity.getRole(), entity.getId());
        if (UserUtils.isModerator() || UserUtils.isEconomic()) {
            dialogService.updateLRMM(entity.getDialogId(), entity.getRole(), entity.getId());
        } else if (UserUtils.isEntrant()) {
            dialogService.updateLREM(entity.getDialogId(), entity.getRole(), entity.getId());
        }
        return messageMapper.toDto(entity);
    }

    public MessageDto getLastMessage(final int id, final String role) {
        return messageMapper.toDto(messageRepository.getLastMessage(id, role));
    }
}
