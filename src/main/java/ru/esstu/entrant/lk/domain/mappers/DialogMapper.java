package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.DialogDto;
import ru.esstu.entrant.lk.domain.vo.Dialog;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DialogMapper {
    public DialogDto toDto(Dialog vo) {
        if (vo == null) {
            return null;
        }
        return new DialogDto(
                vo.getId(),
                vo.getModeratorRole(),
                vo.getEntrantId(),
                vo.getLastMessage()
        );
    }

    public Dialog toVO(DialogDto dto) {
        if (dto == null) {
            return null;
        }
        return new Dialog(
                dto.getId(),
                dto.getModeratorRole(),
                dto.getEntrantId(),
                dto.getLastMessage()
        );
    }
    public List<DialogDto> toDtos (List<Dialog> vos) {
        List<DialogDto> list = new ArrayList<>();
        for (Dialog vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
    
}
