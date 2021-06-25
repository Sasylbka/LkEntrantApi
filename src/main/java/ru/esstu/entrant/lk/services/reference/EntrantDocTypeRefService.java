package ru.esstu.entrant.lk.services.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.EntrantDocTypeDto;
import ru.esstu.entrant.lk.domain.mappers.reference.EntrantDocTypeRefMapper;
import ru.esstu.entrant.lk.repositories.reference.EntrantDocTypeRefRepository;

import java.util.ArrayList;
import java.util.List;
@RestController
@Slf4j
public class EntrantDocTypeRefService {
    private final EntrantDocTypeRefRepository entrantDocTypeRefRepository;
    private final EntrantDocTypeRefMapper entrantDocTypeRefMapper;

    public EntrantDocTypeRefService(EntrantDocTypeRefRepository entrantDocTypeRefRepository,
                                 EntrantDocTypeRefMapper entrantDocTypeRefMapper) {
        this.entrantDocTypeRefRepository = entrantDocTypeRefRepository;
        this.entrantDocTypeRefMapper = entrantDocTypeRefMapper;
    }

    public List<EntrantDocTypeDto> getEntrantDocTypes() {
        List<EntrantDocTypeDto> temp = entrantDocTypeRefMapper.toDtos(entrantDocTypeRefRepository.getEntrantDocTypes());
        List<EntrantDocTypeDto> temp1= new ArrayList<>();
        for(int i =0 ; i<temp.size();i++){
            if(temp.get(i).getFisId()>0){
                temp1.add(temp.get(i));
            }
        }
        return temp1;
    }
}
