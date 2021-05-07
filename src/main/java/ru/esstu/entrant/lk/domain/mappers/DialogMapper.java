package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.DialogDto;
import ru.esstu.entrant.lk.domain.vo.Dialog;
@Slf4j
@Component
public class DialogMapper {
    public DialogDto toDto(Dialog vo) {
        if (vo == null) {
            return null;
        }
        return new DialogDto(
                vo.getId(),
                vo.getModeratorId(),
                vo.getEntrantId()
        );
    }

    public Dialog toVO(DialogDto dto) {
        if (dto == null) {
            return null;
        }
        return new Dialog(
                dto.getId(),
                dto.getModeratorId(),
                dto.getEntrantId()
        );
    }
}
