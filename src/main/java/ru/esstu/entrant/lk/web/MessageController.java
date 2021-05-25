package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.MessageDto;
import ru.esstu.entrant.lk.domain.vo.Message;
import ru.esstu.entrant.lk.services.MessageService;

import java.text.ParseException;
import java.util.List;

@RestController
@Slf4j
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/message")
    public List<MessageDto> get(final int id) {
        return messageService.getMessage(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/message")
    public MessageDto save(@RequestBody final MessageDto MessageDto) throws ParseException {
        return messageService.save(MessageDto);
    }
}
