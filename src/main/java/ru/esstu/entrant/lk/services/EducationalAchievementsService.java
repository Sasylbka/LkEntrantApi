package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
import ru.esstu.entrant.lk.domain.mappers.EducationalAchievementsMapper;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;
import ru.esstu.entrant.lk.repositories.EducationalAchievementsRepository;

@Service
@Slf4j
public class EducationalAchievementsService {

    private final EducationalAchievementsRepository educationalAchievementsRepository;
    private final EducationalAchievementsMapper educationalAchievementsMapper;
    private final AccessService accessService;

    public EducationalAchievementsService(EducationalAchievementsRepository educationalAchievementsRepository,
                                EducationalAchievementsMapper educationalAchievementsMapper,
                                          AccessService accessService) {
        this.educationalAchievementsRepository = educationalAchievementsRepository;
        this.educationalAchievementsMapper = educationalAchievementsMapper;
        this.accessService = accessService;
    }


    public EducationalAchievementsDto getEducationalAchievements(final int id) {
        accessService.commonAccessCheck(id);
        EducationalAchievementsDto temp = educationalAchievementsMapper.toDto(educationalAchievementsRepository.getEducationalAchievements(id));
        if (temp==null){
            temp=new EducationalAchievementsDto();
            return temp;
        }
        return temp;
    }

    public EducationalAchievementsDto save(final EducationalAchievementsDto educationalAchievementsDto) {
        accessService.commonAccessCheck(educationalAchievementsDto.getEntrantId());
        EducationalAchievements entity= educationalAchievementsMapper.toVO(educationalAchievementsDto);
        educationalAchievementsRepository.save(entity);
        return educationalAchievementsMapper.toDto(entity);
    }

    public EducationalAchievementsDto update(final EducationalAchievementsDto educationalAchievementsDto) {
        accessService.commonAccessCheck(educationalAchievementsDto.getEntrantId());
        EducationalAchievements entity= educationalAchievementsMapper.toVO(educationalAchievementsDto);
        educationalAchievementsRepository.update(entity);
        return educationalAchievementsMapper.toDto(entity);
    }
}