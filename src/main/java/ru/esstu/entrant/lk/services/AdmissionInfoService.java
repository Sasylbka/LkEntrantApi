package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.mappers.AdmissionInfoMapper;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;
import ru.esstu.entrant.lk.repositories.AdmissionInfoRepository;

import java.util.List;

@Service
@Slf4j
public class AdmissionInfoService {

    private final AdmissionInfoRepository admissionInfoRepository;
    private final AdmissionInfoMapper admissionInfoMapper;
    private final AccessService accessService;

    public AdmissionInfoService(AdmissionInfoRepository admissionInfoRepository,
                                AdmissionInfoMapper admissionInfoMapper,
                                AccessService accessService) {
        this.admissionInfoRepository = admissionInfoRepository;
        this.admissionInfoMapper = admissionInfoMapper;
        this.accessService = accessService;
    }


    public List<AdmissionInfoDto> getAdmissionInfo(final int id) {
        accessService.commonAccessCheck(id);
        List<AdmissionInfoDto> temp = admissionInfoMapper.toDtos(admissionInfoRepository.getAdmissionInfo(id));
        return temp;
    }
    public AdmissionInfoDto save(final AdmissionInfoDto admissionInfoDto) {
        accessService.commonAccessCheck(admissionInfoDto.getEntrantId());
        AdmissionInfo entity= admissionInfoMapper.toVO(admissionInfoDto);
        admissionInfoRepository.save(entity);
        return admissionInfoMapper.toDto(entity);
    }
    public AdmissionInfoDto update(final AdmissionInfoDto admissionInfoDto) {
        accessService.commonAccessCheck(admissionInfoDto.getEntrantId());
        AdmissionInfo entity= admissionInfoMapper.toVO(admissionInfoDto);
        admissionInfoRepository.update(entity);
        return admissionInfoMapper.toDto(entity);
    }
    public AdmissionInfoDto delete(AdmissionInfoDto admissionInfoDto) {
        accessService.commonAccessCheck(admissionInfoDto.getEntrantId());
        AdmissionInfo entity= admissionInfoMapper.toVO(admissionInfoDto);
        admissionInfoRepository.delete(entity);
        return admissionInfoMapper.toDto(entity);
    }
}