package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.jooq.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.MessageDto;
import ru.esstu.entrant.lk.domain.mappers.DialogMapper;
import ru.esstu.entrant.lk.domain.mappers.MessageMapper;
import ru.esstu.entrant.lk.domain.vo.Dialog;
import ru.esstu.entrant.lk.domain.vo.Message;
import ru.esstu.entrant.lk.repositories.DialogRepository;
import ru.esstu.entrant.lk.repositories.MessageRepository;
import ru.esstu.entrant.lk.utils.UserUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@Service
@Slf4j
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final DialogService dialogService;

    public MessageService(MessageRepository messageRepository,
                          MessageMapper messageMapper, DialogService dialogService,
                          AccessService accessService) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
        this.dialogService = dialogService;
    }


    public List<MessageDto> getMessage(final int id, final String role) {
        List<MessageDto> temp = messageMapper.toDtos(messageRepository.getMessage(id, role));
        MessageDto mes=temp.get(temp.size()-1);//Последнее сообщение
        if (!UserUtils.isModerator()||!UserUtils.isEconomic())
        {
            dialogService.updateLRMM(mes.getDialogId(), mes.getRole(),mes.getId());
        }
        else if(!UserUtils.isEntrant())
        {
            dialogService.updateLREM(mes.getDialogId(), mes.getRole(),mes.getId());
        }
        return temp;
    }

    public MessageDto save(final MessageDto messageDto) throws ParseException {
        Message entity = messageMapper.toVO(messageDto);
        messageRepository.save(entity);
        dialogService.update(entity.getDialogId(), entity.getRole(), entity.getId());
        if (!UserUtils.isModerator()||!UserUtils.isEconomic())
        {
           dialogService.updateLRMM(entity.getDialogId(), entity.getRole(),entity.getId());
        }
        else if(!UserUtils.isEntrant())
        {
            dialogService.updateLREM(entity.getDialogId(), entity.getRole(),entity.getId());
        }
        return messageMapper.toDto(entity);
    }

    public MessageDto getLastMessage(final int id, final String role) {
        MessageDto temp = messageMapper.toDto(messageRepository.getLastMessage(id, role));
        return temp;
    }
}
