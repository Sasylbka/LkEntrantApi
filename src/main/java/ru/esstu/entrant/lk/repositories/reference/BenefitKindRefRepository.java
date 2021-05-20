package ru.esstu.entrant.lk.repositories.reference;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.BenefitKind;

import java.util.List;
@Mapper
public interface BenefitKindRefRepository {
    @Select("SELECT * FROM public.benefit_kind")
    List<BenefitKind> getBenefitKinds();
}
