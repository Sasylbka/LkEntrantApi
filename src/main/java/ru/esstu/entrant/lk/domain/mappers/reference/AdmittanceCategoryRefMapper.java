package ru.esstu.entrant.lk.domain.mappers.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.reference.AdmittanceCategoryDto;
import ru.esstu.entrant.lk.domain.vo.reference.AdmittanceCategory;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class AdmittanceCategoryRefMapper {
    public AdmittanceCategoryDto toDto(AdmittanceCategory vo) {
        if (vo == null) {
            return null;
        }
        return new AdmittanceCategoryDto(
                vo.getAdmittanceCategoryId(),
                vo.getAdmittanceCategoryName()
        );
    }
    public AdmittanceCategory toVO(AdmittanceCategoryDto dto) {
        if (dto == null) {
            return null;
        }
        return new AdmittanceCategory(
                dto.getAdmittanceCategoryId(),
                dto.getAdmittanceCategoryName()
        );
    }
    public List<AdmittanceCategoryDto> toDtos (List<AdmittanceCategory> vos) {
        List<AdmittanceCategoryDto> list = new ArrayList<>();
        for (AdmittanceCategory vo : vos) {
            list.add(toDto(vo));
        }
        return list;
    }
}
