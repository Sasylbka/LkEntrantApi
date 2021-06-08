package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.EducationInfoDto;
import ru.esstu.entrant.lk.domain.dto.EducationInfoDto;
import ru.esstu.entrant.lk.domain.mappers.EducationInfoMapper;
import ru.esstu.entrant.lk.domain.vo.EducationInfo;
import ru.esstu.entrant.lk.domain.vo.EducationInfo;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.repositories.EducationInfoRepository;

@Service
@Slf4j
public class EducationInfoService {

    private final EducationInfoRepository educationInfoRepository;
    private final EducationInfoMapper educationInfoMapper;
    private final AccessService accessService;

    public EducationInfoService(EducationInfoRepository educationInfoRepository,
                                    EducationInfoMapper educationInfoMapper,
                                AccessService accessService) {
        this.educationInfoRepository = educationInfoRepository;
        this.educationInfoMapper = educationInfoMapper;
        this.accessService = accessService;
    }


    public EducationInfoDto getEducationInfo(final int id) {
        //accessService.commonAccessCheck(id);
        EducationInfoDto temp= educationInfoMapper.toDto(educationInfoRepository.getEducationInfo(id));
        if(temp==null){
            temp = new EducationInfoDto();
            return temp;
        }
        return temp;
    }

    public EducationInfoDto save(final EducationInfoDto educationInfoDto) {
        //accessService.commonAccessCheck(educationInfoDto.getEntrantId());
        EducationInfo entity= educationInfoMapper.toVO(educationInfoDto);
        educationInfoRepository.save(entity);
        return educationInfoMapper.toDto(entity);
    }

    public EducationInfoDto update(final EducationInfoDto educationInfoDto) {
        //accessService.commonAccessCheck(educationInfoDto.getEntrantId());
        EducationInfo entity= educationInfoMapper.toVO(educationInfoDto);
        educationInfoRepository.update(entity);
        return educationInfoMapper.toDto(entity);
    }
}