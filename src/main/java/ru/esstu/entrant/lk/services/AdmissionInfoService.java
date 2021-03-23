package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.mappers.AdmissionInfoMapper;
import ru.esstu.entrant.lk.repositories.AdmissionInfoRepository;

@Service
@Slf4j
public class AdmissionInfoService {

    private final AdmissionInfoRepository admissionInfoRepository;
    private final AdmissionInfoMapper admissionInfoMapper;

    public AdmissionInfoService(AdmissionInfoRepository admissionInfoRepository,
                                AdmissionInfoMapper admissionInfoMapper) {
        this.admissionInfoRepository = admissionInfoRepository;
        this.admissionInfoMapper = admissionInfoMapper;
    }


    public AdmissionInfoDto getAdmissionInfo(final String id) {
        return admissionInfoMapper.toDto(admissionInfoRepository.getAdmissionInfo(id));
//        return new TestTableDto(1, "NTCN");
    }
}