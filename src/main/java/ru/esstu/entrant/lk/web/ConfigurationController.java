package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.ConfigurationDto;
import ru.esstu.entrant.lk.domain.vo.Configuration;
import ru.esstu.entrant.lk.services.ConfigurationService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class ConfigurationController {

    /**
     * Сервис.
     */
    private final ConfigurationService configurationService;

    public ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/configuration")
    public ConfigurationDto get() {
        return configurationService.getConfiguration();
    }
}
