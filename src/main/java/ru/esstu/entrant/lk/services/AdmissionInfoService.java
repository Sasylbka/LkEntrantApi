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

import java.util.List;

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


    public List<AdmissionInfoDto> getAdmissionInfo(final int id) {
        List<AdmissionInfoDto> temp = admissionInfoMapper.toDtos(admissionInfoRepository.getAdmissionInfo(id));
        if(temp.size()==0){
            AdmissionInfoDto admissionInfoDto = new AdmissionInfoDto(0,0,null,null,false,false,false,false,false);
            temp.add(admissionInfoDto);
            return temp;
        }
        return temp;
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