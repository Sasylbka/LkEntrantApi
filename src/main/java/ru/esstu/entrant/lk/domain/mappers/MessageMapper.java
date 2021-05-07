package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.MessageDto;
import ru.esstu.entrant.lk.domain.vo.Message;

@Slf4j
@Component
public class MessageMapper {
    public MessageDto toDto(Message vo) {
        if (vo == null) {
            return null;
        }
        return new MessageDto(
                vo.getId(),
                vo.getDialogId(),
                vo.getMessage(),
                vo.getDate()
        );
    }

    public Message toVO(MessageDto dto) {
        if (dto == null) {
            return null;
        }
        return new Message(
                dto.getId(),
                dto.getDialogId(),
                dto.getMessage(),
                dto.getDate()
        );
    }
}
