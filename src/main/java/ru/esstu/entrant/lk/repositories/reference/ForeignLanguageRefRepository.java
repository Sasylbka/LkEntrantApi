package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.ForeignLanguage;
import ru.esstu.entrant.lk.domain.vo.reference.MilitaryStatus;

import java.util.List;

@Mapper
public interface ForeignLanguageRefRepository {
    @Select("SELECT * FROM public.foreign_language")
    List<ForeignLanguage> getForeignLanguage();
    @Select("Select lang_id From public.foreign_language where language_name=#{languageName}")
    ForeignLanguage getOne(@Param("languageName") String languageName);
}
