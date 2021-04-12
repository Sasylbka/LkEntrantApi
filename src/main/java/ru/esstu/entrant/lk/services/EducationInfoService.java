package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.EducationInfoDto;
import ru.esstu.entrant.lk.domain.mappers.EducationInfoMapper;
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


    public EducationInfoDto getEducationInfo(final String id) {
        return educationInfoMapper.toDto(educationInfoRepository.getEducationInfo(id));
//        return new TestTableDto(1, "NTCN");
    }
    public EducationInfo postEducationInfo(final String id, final String education , final String year_of_finished,final String document_of_education,final String document_of_education_serial_number,final String place_of_finished,final String date_of_finished,final String studied_language,final String if_choosen_level_of_education_first) {
        return educationInfoMapper.toVO(educationInfoRepository.postEducationInfo(id,education,year_of_finished,document_of_education,document_of_education_serial_number,place_of_finished,date_of_finished,studied_language,if_choosen_level_of_education_first));
    }
}