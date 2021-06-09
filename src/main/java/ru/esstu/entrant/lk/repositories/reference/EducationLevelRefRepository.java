package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.EducationLevel;

import java.util.List;
@Mapper
public interface EducationLevelRefRepository {
    @Select("SELECT * FROM public.educational_level")
    List<EducationLevel> getEducationLevels();

}
