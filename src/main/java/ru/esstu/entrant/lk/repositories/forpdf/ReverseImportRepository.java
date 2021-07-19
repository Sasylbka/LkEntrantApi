package ru.esstu.entrant.lk.repositories.forpdf;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.*;
import ru.esstu.entrant.lk.domain.vo.Additionals.Keycloak;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;
import ru.esstu.entrant.lk.domain.vo.forpdf.AdditionalInformationForPDF;
import ru.esstu.entrant.lk.domain.vo.forpdf.EducationInfoForPDF;
import ru.esstu.entrant.lk.domain.vo.forpdf.EntrantPrivateDataForPDF;

import java.util.List;

@Mapper
public interface ReverseImportRepository {

    //1 и 5 military_status_id
    @Select("SELECT public.person.surname, public.person.name, public.person.patronymic, " +
            "public.person.male, public.person.birthdate, public.person.birth_region, public.person.birth_city, " +
            "public.person.snills, public.entrant.military_status_id, public.entrant.need_hostel " +
            "FROM public.person, public.entrant " +
            "WHERE public.person.person_id=#{personId} and public.entrant.entrant_id=#{personId})")
    EntrantPrivateDataForPDF getEntrantPrivateDataFromPublic(@Param("personId")String personId);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Select("SELECT doc_series, doc_number, releasing_org_name, department_code, release_date " +
            "FROM public.identification_info " +
            "WHERE public.identification_info.person_id=#{personId})")
    PassportData getPassportDataFromPublic(@Param("personId")String personId);
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    @Select("SELECT public.educational_document.edu_inst_type_id, public.educational_document.end_year, " +
            "public.educational_document.edu_doc_type, public.educational_document.doc_series, " +
            "public.educational_document.doc_number, public.educational_document.region_id, " +
            "public.entrant.graduation_place_id, public.educational_document.city, " +
            "public.educational_document.edu_inst_name, " +
            "public.educational_document.doc_date, public.entrant_lang_mtm.lang_id" +
            "FROM public.educational_document, public.entrant, public.entrant_lang_mtm " +
            "WHERE public.educational_document.entrant_id=#{personId} " +
            "and public.entrant.entrant_id=#{personId} " +
            "and public.entrant_lang_mtm.person_id=#{personId})")
    EducationInfoForPDF getEducInfoFromPublic(@Param("personId")String personId);
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    @Select("SELECT public.address.region_id, public.address.district_id, public.address.city, " +
            "public.address.street, public.address.building_num, public.address.flat_num, " +
            "public.address.index, public.person_address_mtm.address_type_id" +
            "FROM public.address, public.person_address_mtm " +
            "WHERE public.person_address_mtm.person_id=#{personId} " +
            "and public.person_address_mtm.addr_id=public.address.addr_id)")
    List<AdditionalInformationForPDF> getAdditionalInfoFromPublic(@Param("personId")String personId);
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    @Select("SELECT pager " +
            "FROM public.person " +
            "WHERE public.person_id.person_id=#{personId})")
    ContactInformation getContactFromPublic(@Param("personId")String personId);
    ///////////*НЕОБХОДИМО СДЕЛАТЬ УЧЕБНЫЕ ДОСТИЖЕНИЯ, ЛЬГОТЫ, РОДИТЕЛЕЙ, НАПРАВЛЕНИЯ И СОГЛАСИЕ *////////////////////
}
