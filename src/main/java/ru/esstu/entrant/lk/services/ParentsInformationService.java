package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.ParentsInformationDto;
import ru.esstu.entrant.lk.domain.mappers.ParentsInformationMapper;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.domain.vo.ParentsInformation;
import ru.esstu.entrant.lk.repositories.ParentsInformationRepository;

@Service
@Slf4j
public class ParentsInformationService {

    private final ParentsInformationRepository parentsInformationRepository;
    private final ParentsInformationMapper parentsInformationMapper;

    public ParentsInformationService(ParentsInformationRepository parentsInformationRepository,
                                ParentsInformationMapper parentsInformationMapper) {
        this.parentsInformationRepository = parentsInformationRepository;
        this.parentsInformationMapper = parentsInformationMapper;
    }


    public ParentsInformationDto getParentsInformation(final String id) {
        return parentsInformationMapper.toDto(parentsInformationRepository.getParentsInformation(id));
//        return new TestTableDto(1, "NTCN");
    }
    public ParentsInformation postParentsInformation(final String id, final String father_mobile_number , final String father_name,final String father_second_name,final String father_patronymic,final String place_of_father_job,final String mother_mobile_number,final String mother_name,final String mother_second_name,final String mother_patronymic,final String place_of_mother_job,final String additional_phone_number) {
        return parentsInformationMapper.toVO(parentsInformationRepository.postParentsInformation(id,father_mobile_number,father_name,father_second_name,father_patronymic,place_of_father_job,mother_mobile_number,mother_name,mother_second_name,mother_patronymic,place_of_mother_job,additional_phone_number));
    }
}