package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.MessageDto;
import ru.esstu.entrant.lk.domain.mappers.MessageMapper;
import ru.esstu.entrant.lk.domain.vo.Message;
import ru.esstu.entrant.lk.repositories.MessageRepository;

import java.util.List;

@Service
@Slf4j
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageService(MessageRepository messageRepository,
                         MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }


    public List<MessageDto> getMessage(final int id) {
        List<MessageDto> temp = messageMapper.toDtos(messageRepository.getMessage(id));
        if(temp.size()==0){
            MessageDto messageDto = new MessageDto(0,0,null,null,null);
            temp.add(messageDto);
            return temp;
        }
        return temp;
    }
    public MessageDto save(final MessageDto messageDto) {
        Message entity= messageMapper.toVO(messageDto);
        messageRepository.save(entity);
        return messageMapper.toDto(entity);
    }
}
