package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.EducationalAchievementsDto;
import ru.esstu.entrant.lk.domain.mappers.EducationalAchievementsMapper;
import ru.esstu.entrant.lk.domain.vo.EducationalAchievements;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
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


    public EducationalAchievementsDto getEducationalAchievements(final String id) {
        return educationalAchievementsMapper.toDto(educationalAchievementsRepository.getEducationalAchievements(id));
    }
    public EducationalAchievements postEducationalAchievements(final String id, final String medal , final String honors_degree, final String olympiad_participation, final String document_of_olympiad_victories, final String document_of_olympiad_victories_serial_number, final String issued_by, final String data_of_issued, final String candidate_minimums_passed) {
        return educationalAchievementsMapper.toVO(educationalAchievementsRepository.postEducationalAchievements(id,medal,honors_degree,olympiad_participation,document_of_olympiad_victories,document_of_olympiad_victories_serial_number,issued_by,data_of_issued,candidate_minimums_passed));
    }
}