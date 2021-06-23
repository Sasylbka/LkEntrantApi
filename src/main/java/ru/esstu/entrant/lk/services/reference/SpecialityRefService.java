package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.reference.SpecialityDto;
import ru.esstu.entrant.lk.domain.mappers.reference.SpecialityRefMapper;
import ru.esstu.entrant.lk.domain.vo.reference.Speciality;
import ru.esstu.entrant.lk.repositories.reference.SpecialityRefRepository;

import java.util.List;
@Service
@Slf4j
public class SpecialityRefService {
    private final SpecialityRefRepository specialityRefRepository;
    private final SpecialityRefMapper specialityRefMapper;

    public SpecialityRefService(SpecialityRefRepository specialityRefRepository,
                            SpecialityRefMapper specialityRefMapper) {
        this.specialityRefRepository = specialityRefRepository;
        this.specialityRefMapper = specialityRefMapper;
    }

    public List<SpecialityDto> getSpecialities() {
        List<Speciality> temp=specialityRefRepository.getSpecialities();
        for(int i=0;i<temp.size();i++)
        {
            if(temp.get(i).getFacultyId()==13)
            {
                temp.get(i).setAccelerated(true);
            }
        }
        return specialityRefMapper.toDtos(temp);
    }
}
