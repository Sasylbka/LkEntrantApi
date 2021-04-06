package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.PassportDataDto;
import ru.esstu.entrant.lk.domain.mappers.PassportDataMapper;
import ru.esstu.entrant.lk.repositories.PassportDataRepository;

@Service
@Slf4j
public class PassportDataService {

    private final PassportDataRepository passportDataRepository;
    private final PassportDataMapper passportDataMapper;

    public PassportDataService(PassportDataRepository passportDataRepository,
                               PassportDataMapper passportDataMapper) {
        this.passportDataRepository = passportDataRepository;
        this.passportDataMapper = passportDataMapper;
    }

    public PassportDataDto getPassportData(final String id) {
        return passportDataMapper.toDto(passportDataRepository.getPassportData(id));
//        return new TestTableDto(1, "NTCN");
    }
}
