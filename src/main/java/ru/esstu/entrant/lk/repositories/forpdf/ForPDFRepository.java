package ru.esstu.entrant.lk.repositories.forpdf;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.PublicTables.EducationalDocument;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;

@Mapper
public interface ForPDFRepository {
    @Select("SELECT graduation_place_name From public.graduation_place WHERE graduation_place_id=#{id}")
    String getDistrict(@Param("id") int id);

    @Select("SELECT region_name From public.region WHERE region_id=#{id}")
    String getRegion(@Param("id") int id);

    @Select("SELECT speciality_name From public.speciality WHERE spec_id=#{id}")
    String getDirection(@Param("id") int id);

    @Select("SELECT edu_form_name " +
            "FROM public.educational_form, public.speciality " +
            "WHERE public.speciality.spec_id=#{id} and public.educational_form.edu_form_id=public.speciality.edu_form_id")
    String getEduForm(@Param("id") int id);

    @Select("SELECT edu_form_name " +
            "FROM public.educational_level, public.speciality " +
            "WHERE public.speciality.spec_id=#{id} and public.educational_level.edu_level_id=public.speciality.edu_level_id")
    String getEduLevel(@Param("id") int id);

    @Select("SELECT public.edu_institution_type.name " +
            "FROM public.edu_institution_type, public.educational_document " +
            "WHERE public.educational_document.edu_inst_type_id=public.edu_institution_type.edu_inst_type_id " +
            "and public.educational_document.edu_inst_type_id=#{id}")
    String getInstTypeName(@Param("id") int id);

    @Select("SELECT lang_name " +
            "FROM public.foreign_language " +
            "WHERE public.foreign_language.lang_id=#{id}")
    String getLanguage(@Param("id") int id);
}
