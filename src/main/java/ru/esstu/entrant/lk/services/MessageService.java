package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.MessageDto;
import ru.esstu.entrant.lk.domain.mappers.DialogMapper;
import ru.esstu.entrant.lk.domain.mappers.MessageMapper;
import ru.esstu.entrant.lk.domain.vo.Message;
import ru.esstu.entrant.lk.repositories.DialogRepository;
import ru.esstu.entrant.lk.repositories.MessageRepository;

import java.text.ParseException;
import java.util.List;

@Service
@Slf4j
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final DialogService dialogService;
    private final DialogRepository dialogRepository;
    private final DialogMapper dialogMapper;

    public MessageService(MessageRepository messageRepository,
                          MessageMapper messageMapper, DialogService dialogService, DialogRepository dialogRepository,
                          DialogMapper dialogMapper,
                          AccessService accessService) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
        this.dialogRepository = dialogRepository;
        this.dialogMapper = dialogMapper;
        this.dialogService = dialogService;
    }


    public List<MessageDto> getMessage(final int id, final String role) {
        List<MessageDto> temp = messageMapper.toDtos(messageRepository.getMessage(id, role));
        return temp;
    }

    public MessageDto save(final MessageDto messageDto) throws ParseException {
        Message entity = messageMapper.toVO(messageDto);
        messageRepository.save(entity);
        dialogService.update(entity.getDialogId(), entity.getRole(), entity.getId());
        return messageMapper.toDto(entity);
    }

    public MessageDto getLastMessage(final int id, final String role) {
        MessageDto temp = messageMapper.toDto(messageRepository.getLastMessage(id, role));
        return temp;
    }
}
