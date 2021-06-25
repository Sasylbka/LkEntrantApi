package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.AdmittanceCategory;
import ru.esstu.entrant.lk.domain.vo.reference.BenefitKind;

import java.util.List;

@Mapper
public interface AdmittanceCategoryRefRepository {
    @Select("SELECT * FROM public.admittance_category")
    List<AdmittanceCategory> getAdmittanceCategories();
}
