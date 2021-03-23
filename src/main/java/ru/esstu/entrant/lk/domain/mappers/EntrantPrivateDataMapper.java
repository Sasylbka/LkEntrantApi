package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.EntrantPrivateDataDto;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;

/**
 * Маппер.
 */
@Slf4j
@Component
public class EntrantPrivateDataMapper {

    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public EntrantPrivateDataDto toDto(EntrantPrivateData vo) {
        if (vo == null) {
            return null;
        }
        return new EntrantPrivateDataDto(
                vo.getId(),
                vo.getName(),
                vo.getFamily_name(),
                vo.getPatronymic(),
                vo.getGender(),
                vo.getDate_of_birth(),
                vo.getCity_of_birth(),
                vo.getRegion_of_birth()
        );
    }

    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public EntrantPrivateData toVO(EntrantPrivateDataDto dto) {
        if (dto == null) {
            return null;
        }
        return new EntrantPrivateData(
                dto.getId(),
                dto.getName(),
                dto.getFamily_name(),
                dto.getPatronymic(),
                dto.getGender(),
                dto.getDate_of_birth(),
                dto.getCity_of_birth(),
                dto.getRegion_of_birth()
        );
    }
}
