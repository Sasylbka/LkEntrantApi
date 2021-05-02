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

    public EducationInfoService(EducationInfoRepository educationInfoRepository,
                                    EducationInfoMapper educationInfoMapper) {
        this.educationInfoRepository = educationInfoRepository;
        this.educationInfoMapper = educationInfoMapper;
    }


    public EducationInfoDto getEducationInfo(final int id) {
        return educationInfoMapper.toDto(educationInfoRepository.getEducationInfo(id));
//        return new TestTableDto(1, "NTCN");
    }

    public EducationInfoDto save(final EducationInfoDto educationInfoDto) {
        EducationInfo entity= educationInfoMapper.toVO(educationInfoDto);
        educationInfoRepository.save(entity);
        return educationInfoMapper.toDto(entity);
    }
}