package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.Speciality;

import java.util.List;
@Mapper
public interface SpecialityRefRepository {
    @Select("SELECT public.speciality.spec_id, public.speciality.edu_form_id, public.speciality.speciality_name, public.speciality.edu_level_id, public.speciality_code.spec_code " +
            "FROM public.speciality, public.speciality_code WHERE public.speciality.spec_code_id=public.speciality_code.spec_id;")
    List<Speciality> getSpecialities();
}
