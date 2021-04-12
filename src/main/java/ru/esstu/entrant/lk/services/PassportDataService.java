package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.PassportDataDto;
import ru.esstu.entrant.lk.domain.mappers.PassportDataMapper;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.domain.vo.PassportData;
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
    public PassportData postPassportData(final String id, final String serial_number , final String place_of_issue,final String code_of_subdivision,final String date_of_issue) {
        return passportDataMapper.toVO(passportDataRepository.postPassportData(id,serial_number,place_of_issue,code_of_subdivision,date_of_issue));
    }
}
