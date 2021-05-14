package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.ConsentDto;
import ru.esstu.entrant.lk.domain.dto.ConsentDto;
import ru.esstu.entrant.lk.domain.mappers.ConsentMapper;
import ru.esstu.entrant.lk.domain.vo.Consent;
import ru.esstu.entrant.lk.domain.vo.Consent;
import ru.esstu.entrant.lk.repositories.ConsentRepository;

@Service
@Slf4j
public class ConsentService {

    private final ConsentRepository consentRepository;
    private final ConsentMapper consentMapper;

    public ConsentService(ConsentRepository consentRepository,
                                 ConsentMapper consentMapper) {
        this.consentRepository = consentRepository;
        this.consentMapper = consentMapper;
    }
    public ConsentDto getConsent(final int id) {
        return consentMapper.toDto(consentRepository.getConsent(id));
    }
    public ConsentDto save(final ConsentDto consentDto) {
        Consent entity= consentMapper.toVO(consentDto);
        consentRepository.save(entity);
        return consentMapper.toDto(entity);
    }
    public ConsentDto update(final ConsentDto consentDto) {
        Consent entity= consentMapper.toVO(consentDto);
        consentRepository.update(entity);
        return consentMapper.toDto(entity);
    }
}