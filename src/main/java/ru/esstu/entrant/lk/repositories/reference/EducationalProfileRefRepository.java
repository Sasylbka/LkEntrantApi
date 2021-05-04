package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.EducationalProfile;

import java.util.List;

@Mapper
public interface EducationalProfileRefRepository {
    @Select("SELECT * FROM public.educational_profile")
    List<EducationalProfile> getEducationalProfiles();

    // TO DO остальные справочники
}