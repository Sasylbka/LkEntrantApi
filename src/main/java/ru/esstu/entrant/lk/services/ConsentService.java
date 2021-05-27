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
    private final AccessService accessService;

    public ConsentService(ConsentRepository consentRepository,
                          ConsentMapper consentMapper,
                          AccessService accessService) {
        this.consentRepository = consentRepository;
        this.consentMapper = consentMapper;
        this.accessService = accessService;
    }
    public ConsentDto getConsent(final int id) {
        accessService.commonAccessCheck(id);
        ConsentDto temp =  consentMapper.toDto(consentRepository.getConsent(id));
        if(temp==null){
            temp=new ConsentDto();
            return temp;
        }
        return temp;
    }
    public ConsentDto save(final ConsentDto consentDto) {
        accessService.commonAccessCheck(consentDto.getEntrantId());
        Consent entity= consentMapper.toVO(consentDto);
        consentRepository.save(entity);
        return consentMapper.toDto(entity);
    }
    public ConsentDto update(final ConsentDto consentDto) {
        accessService.commonAccessCheck(consentDto.getEntrantId());
        Consent entity= consentMapper.toVO(consentDto);
        consentRepository.update(entity);
        return consentMapper.toDto(entity);
    }
}