package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.EntrantPrivateDataDto;
import ru.esstu.entrant.lk.domain.mappers.EntrantPrivateDataMapper;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.repositories.EntrantPrivateDataRepository;

@Service
@Slf4j
public class EntrantPrivateDataService {

    private final EntrantPrivateDataRepository entrantPrivateDataRepository;
    private final EntrantPrivateDataMapper entrantPrivateDataMapper;

    public EntrantPrivateDataService(EntrantPrivateDataRepository entrantPrivateDataRepository,
                                     EntrantPrivateDataMapper entrantPrivateDataMapper) {
        this.entrantPrivateDataRepository = entrantPrivateDataRepository;
        this.entrantPrivateDataMapper = entrantPrivateDataMapper;
    }


    public EntrantPrivateDataDto getEntrantPrivateData(final String id) {
        return entrantPrivateDataMapper.toDto(entrantPrivateDataRepository.getEntrantPrivateData(id));
//        return new TestTableDto(1, "NTCN");
    }
    public EntrantPrivateData postEntrantPrivateData(final String id, final String name , final String family_name, final String patronymic, final String gender, final String date_of_birth, final String city_of_birth, final String region_of_birth) {
        return entrantPrivateDataMapper.toVO(entrantPrivateDataRepository.postEntrantPrivateData(id,name,family_name,patronymic,gender,date_of_birth,city_of_birth,region_of_birth));
    }

}
