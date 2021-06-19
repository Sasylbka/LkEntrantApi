package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.ConfigurationDto;
import ru.esstu.entrant.lk.domain.vo.Configuration;
/**
 * Маппер.
 */
@Slf4j
@Component
public class ConfigurationMapper {
    /**
     * Преобразование.
     * @param vo объект
     * @return dto
     */
    public ConfigurationDto toDto(Configuration vo) {
        if (vo == null) {
            return null;
        }
        return new ConfigurationDto(
                vo.getId(),
                vo.getMaxWithdrawalOfConsent(),
                vo.getLastDateBudget(),
                vo.getLastDateQuote()
        );
    }
    /**
     * Преобразование.
     * @param dto объект
     * @return dto
     */
    public Configuration toVO(ConfigurationDto dto) {
        if (dto == null) {
            return null;
        }
        return new Configuration(
                dto.getId(),
                dto.getMaxWithdrawalOfConsent(),
                dto.getLastDateBudget(),
                dto.getLastDateQuote()
        );
    }
}
