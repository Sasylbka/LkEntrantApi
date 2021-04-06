package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.JobInformationDto;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
/**
 * Маппер.
 */
@Slf4j
@Component
public class JobInformationMapper {
    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public JobInformationDto toDto(JobInformation vo) {
        if (vo == null) {
            return null;
        }
        return new JobInformationDto(
                vo.getId(),
                vo.getPlace_of_job(),
                vo.getPosition()
        );
    }
    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public JobInformation toVO(JobInformationDto dto) {
        if (dto == null) {
            return null;
        }
        return new JobInformation(
                dto.getId(),
                dto.getPlace_of_job(),
                dto.getPosition()
        );
    }
}
