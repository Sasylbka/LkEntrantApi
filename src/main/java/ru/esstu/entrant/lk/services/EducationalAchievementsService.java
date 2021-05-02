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

    public EducationalAchievementsService(EducationalAchievementsRepository educationalAchievementsRepository,
                                EducationalAchievementsMapper educationalAchievementsMapper) {
        this.educationalAchievementsRepository = educationalAchievementsRepository;
        this.educationalAchievementsMapper = educationalAchievementsMapper;
    }


    public EducationalAchievementsDto getEducationalAchievements(final int id) {
        return educationalAchievementsMapper.toDto(educationalAchievementsRepository.getEducationalAchievements(id));
    }

    public EducationalAchievementsDto save(final EducationalAchievementsDto educationalAchievementsDto) {
        EducationalAchievements entity= educationalAchievementsMapper.toVO(educationalAchievementsDto);
        educationalAchievementsRepository.save(entity);
        return educationalAchievementsMapper.toDto(entity);
    }
}