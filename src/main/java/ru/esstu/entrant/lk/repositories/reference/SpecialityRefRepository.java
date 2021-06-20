package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.Speciality;

import java.util.List;
@Mapper
public interface SpecialityRefRepository {
    @Select("SELECT public.speciality.spec_id, " +
            "public.speciality.edu_form_id, " +
            "public.speciality.speciality_name, " +
            "public.speciality.edu_level_id, " +
            "public.speciality_code.spec_code, " +
            "public.acceptance_plan.number_budget, " +
            "public.acceptance_plan.number_paid, " +
            "public.acceptance_plan.number_target, " +
            "public.acceptance_plan.number_benefit " +
            "FROM public.speciality " +
            "left join public.speciality_code on public.speciality.spec_code_id=public.speciality_code.spec_id " +
            "left join public.acceptance_plan on public.speciality.spec_id=public.acceptance_plan.spec_id ")
    List<Speciality> getSpecialities();
}
