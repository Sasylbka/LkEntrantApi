package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.mappers.AdmissionInfoMapper;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;
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


    public AdmissionInfoDto getAdmissionInfo(final int id) {
        return admissionInfoMapper.toDto(admissionInfoRepository.getAdmissionInfo(id));
    }
    public AdmissionInfoDto save(final AdmissionInfoDto admissionInfoDto) {
        AdmissionInfo entity= admissionInfoMapper.toVO(admissionInfoDto);
        admissionInfoRepository.save(entity);
        return admissionInfoMapper.toDto(entity);
    }
    public AdmissionInfoDto update(final AdmissionInfoDto admissionInfoDto) {
        AdmissionInfo entity= admissionInfoMapper.toVO(admissionInfoDto);
        admissionInfoRepository.update(entity);
        return admissionInfoMapper.toDto(entity);
    }
}