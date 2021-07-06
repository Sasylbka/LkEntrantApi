package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.EntrantTestDto;
import ru.esstu.entrant.lk.domain.dto.EntrantTestDto;
import ru.esstu.entrant.lk.domain.vo.EntrantTest;
import ru.esstu.entrant.lk.domain.vo.EntrantTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Маппер.
 */
@Slf4j
@Component
public class EntrantTestMapper {
    public EntrantTestDto toDto(EntrantTest vo) {
        if (vo == null) {
            return null;
        }
        return new EntrantTestDto(
                vo.getUsername(),
                vo.getPasswordText(),
                vo.getExamDate(),
                vo.getDiscName(),
                vo.getStartTestTime(),
                vo.getEnabled(),
                vo.getBall(),
                vo.getPlace()
        );
    }

    public EntrantTest toVO(EntrantTestDto dto) {
        if (dto == null) {
            return null;
        }
        return new EntrantTest(
                dto.getUsername(),
                dto.getPasswordText(),
                dto.getExamDate(),
                dto.getDiscName(),
                dto.getStartTestTime(),
                dto.getEnabled(),
                dto.getBall(),
                dto.getPlace()
        );
    }
    public List<EntrantTestDto> toDtos (List<EntrantTest> vos) {
        List<EntrantTestDto> list = new ArrayList<>();
        for (EntrantTest vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
