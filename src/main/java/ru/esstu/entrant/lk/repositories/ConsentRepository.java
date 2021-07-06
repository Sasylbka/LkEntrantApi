package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.Consent;

import java.util.List;

@Mapper
public interface ConsentRepository {
    @Select("SELECT * FROM consent WHERE entrant_id = #{id}")
    List<Consent> getConsent(@Param("id") int id);//получение всеё истории действий для определённого пользователя

    @Select("SELECT * FROM consent WHERE entrant_id = #{id} and action_type='ADD'")
    List<Consent> getFullAdd(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO consent(entrant_id, admission_info_id, form_of_financing, date, action_type) " +
            "VALUES(#{consent.entrantId},#{consent.admissionInfoId},#{consent.formOfFinancing},#{consent.date},#{consent.actionType})")
    long save(@Param("consent") Consent consent);// сохранение действия в базу данных

    @Options(keyProperty = "id", keyColumn = "id")
    @Update("UPDATE consent SET " +
            "admission_info_id=#{consent.admissionInfoId}, form_of_financing=#{consent.formOfFinancing}, date=#{consent.date}, action_type#{consent.actionType} " +
            "WHERE entrant_id=#{consent.entrantId}")
    long update(@Param("consent") Consent consent);// обновление действия в базе данных для определённого пользователя
}