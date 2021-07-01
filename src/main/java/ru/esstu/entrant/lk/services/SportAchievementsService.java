package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.SportAchievementsDto;
import ru.esstu.entrant.lk.domain.mappers.SportAchievementsMapper;
import ru.esstu.entrant.lk.domain.vo.SportAchievements;
import ru.esstu.entrant.lk.repositories.SportAchievementsRepository;

import java.util.List;

@Service
@Slf4j
public class SportAchievementsService {

    private final SportAchievementsRepository sportAchievementsRepository;
    private final SportAchievementsMapper sportAchievementsMapper;
    private final AccessService accessService;

    public SportAchievementsService(SportAchievementsRepository sportAchievementsRepository,
                                    SportAchievementsMapper sportAchievementsMapper,
                                    AccessService accessService) {
        this.sportAchievementsRepository = sportAchievementsRepository;
        this.sportAchievementsMapper = sportAchievementsMapper;
        this.accessService = accessService;
    }


    public List<SportAchievementsDto> getSportAchievementsList(final int id) {
        accessService.commonAccessCheck(id);
        List<SportAchievementsDto> temp = sportAchievementsMapper.toDtos(sportAchievementsRepository.getSportAchievementsList(id));
        return temp;
    }

    public SportAchievementsDto save(final SportAchievementsDto sportAchievementsDto) {
        accessService.commonAccessCheck(sportAchievementsDto.getEntrantId());
        SportAchievements entity= sportAchievementsMapper.toVO(sportAchievementsDto);
        sportAchievementsRepository.save(entity);
        return sportAchievementsMapper.toDto(entity);
    }

    public SportAchievementsDto update(final SportAchievementsDto sportAchievementsDto) {
        accessService.commonAccessCheck(sportAchievementsDto.getEntrantId());
        SportAchievements entity= sportAchievementsMapper.toVO(sportAchievementsDto);
        sportAchievementsRepository.update(entity);
        return sportAchievementsMapper.toDto(entity);
    }
}