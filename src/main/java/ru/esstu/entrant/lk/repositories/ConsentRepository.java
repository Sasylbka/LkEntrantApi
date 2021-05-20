package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.Consent;

@Mapper
public interface ConsentRepository {
    @Select("SELECT * FROM consent WHERE entrant_id = #{id}")
    Consent getConsent(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO consent(entrant_id, admission_info_id, date, action_type) " +
            "VALUES(#{consent.entrantId},#{consent.admissionInfoId},#{consent.date},#{consent.actionType})")
    long save(@Param("consent") Consent consent);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE consent SET " +
            "admission_info_id=#{consent.admissionInfoId}, date=#{consent.date}, action_type#{consent.actionType} " +
            "WHERE entrant_id=#{consent.entrantId}")
    long update(@Param("consent") Consent consent);
}