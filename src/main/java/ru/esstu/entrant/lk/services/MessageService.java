package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.MessageDto;
import ru.esstu.entrant.lk.domain.mappers.MessageMapper;
import ru.esstu.entrant.lk.domain.vo.Message;
import ru.esstu.entrant.lk.repositories.MessageRepository;

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

    public MessageService(MessageRepository messageRepository,
                         MessageMapper messageMapper,
                          AccessService accessService) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }


    public List<MessageDto> getMessage(final int id) {
        List<MessageDto> temp = messageMapper.toDtos(messageRepository.getMessage(id));
        return temp;
    }
    public MessageDto save(final MessageDto messageDto) throws ParseException {
        Message entity= messageMapper.toVO(messageDto);
        messageRepository.save(entity);
        return messageMapper.toDto(entity);
    }
}
