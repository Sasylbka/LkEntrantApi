package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.ConfigurationDto;
import ru.esstu.entrant.lk.domain.dto.ConfigurationDto;
import ru.esstu.entrant.lk.domain.mappers.ConfigurationMapper;
import ru.esstu.entrant.lk.domain.vo.Configuration;
import ru.esstu.entrant.lk.domain.vo.Configuration;
import ru.esstu.entrant.lk.repositories.ConfigurationRepository;

@Service
@Slf4j
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;
    private final ConfigurationMapper configurationMapper;
    private final AccessService accessService;

    public ConfigurationService(ConfigurationRepository configurationRepository,
                                ConfigurationMapper configurationMapper,
                                AccessService accessService) {
        this.configurationRepository = configurationRepository;
        this.configurationMapper = configurationMapper;
        this.accessService = accessService;
    }
    public ConfigurationDto getConfiguration() {
        ConfigurationDto temp =  configurationMapper.toDto(configurationRepository.getConfiguration());
        if(temp==null){
            temp=new ConfigurationDto();
            return temp;
        }
        return temp;
    }

}