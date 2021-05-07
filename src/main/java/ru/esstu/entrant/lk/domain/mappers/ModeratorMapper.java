package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.ModeratorDto;
import ru.esstu.entrant.lk.domain.vo.Moderator;
@Slf4j
@Component
public class ModeratorMapper    {
    public ModeratorDto toDto(Moderator vo) {
        if (vo == null) {
            return null;
        }
        return new ModeratorDto(
                vo.getId(),
                vo.getLogin(),
                vo.getPassword(),
                vo.getFirst_name(),
                vo.getSecond_name(),
                vo.getPatronymic()
        );
    }

    public Moderator toVO(ModeratorDto dto) {
        if (dto == null) {
            return null;
        }
        return new Moderator(
                dto.getId(),
                dto.getLogin(),
                dto.getPassword(),
                dto.getFirst_name(),
                dto.getSecond_name(),
                dto.getPatronymic()
        );
    }
}
