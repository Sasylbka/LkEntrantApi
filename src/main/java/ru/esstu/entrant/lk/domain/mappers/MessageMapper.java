package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.MessageDto;
import ru.esstu.entrant.lk.domain.dto.MessageDto;
import ru.esstu.entrant.lk.domain.vo.Message;
import ru.esstu.entrant.lk.domain.vo.Message;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class MessageMapper {
    public MessageDto toDto(Message vo) {
        if (vo == null) {
            return null;
        }
        return new MessageDto(
                vo.getId(),
                vo.getRole(),
                vo.getDialogId(),
                vo.getSenderId(),
                vo.getSender(),
                vo.getMessage(),
                vo.getDate(),
                vo.isAttachments(),
                vo.getFilesGuid(),
                vo.getFileName()
        );
    }

    public Message toVO(MessageDto dto) {
        if (dto == null) {
            return null;
        }
        return new Message(
                dto.getId(),
                dto.getRole(),
                dto.getDialogId(),
                dto.getSenderId(),
                dto.getSender(),
                dto.getMessage(),
                dto.getDate(),
                dto.isAttachments(),
                dto.getFilesGuid(),
                dto.getFileName()
        );
    }
    public List<MessageDto> toDtos (List<Message> vos) {
        List<MessageDto> list = new ArrayList<>();
        for (Message vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
