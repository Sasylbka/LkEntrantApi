package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.ParentsInformationDto;
import ru.esstu.entrant.lk.domain.vo.ParentsInformation;
/**
 * Маппер.
 */
@Slf4j
@Component
public class ParentsInformationMapper {
    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public ParentsInformationDto toDto(ParentsInformation vo) {
        if (vo == null) {
            return null;
        }
        return new ParentsInformationDto(
                vo.getId(),
                vo.getFather_mobile_number(),
                vo.getFather_name(),
                vo.getFather_second_name(),
                vo.getFather_patronymic(),
                vo.getPlace_of_father_job(),
                vo.getMother_mobile_number(),
                vo.getMother_name(),
                vo.getMother_second_name(),
                vo.getMother_patronymic(),
                vo.getPlace_of_mother_job(),
                vo.getAdditional_phone_number()
        );
    }
    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public ParentsInformation toVO(ParentsInformationDto dto) {
        if (dto == null) {
            return null;
        }
        return new ParentsInformation(
                dto.getId(),
                dto.getFather_mobile_number(),
                dto.getFather_name(),
                dto.getFather_second_name(),
                dto.getFather_patronymic(),
                dto.getPlace_of_father_job(),
                dto.getMother_mobile_number(),
                dto.getMother_name(),
                dto.getMother_second_name(),
                dto.getMother_patronymic(),
                dto.getPlace_of_mother_job(),
                dto.getAdditional_phone_number()
        );
    }
}
