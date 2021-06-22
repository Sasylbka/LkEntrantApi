package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;
import ru.esstu.entrant.lk.domain.vo.reference.Region;

import java.util.List;

@Mapper
public interface AdmissionInfoRepository {
    @Select("SELECT * FROM admission_info WHERE entrant_id=#{id}")
    List<AdmissionInfo> getAdmissionInfos(@Param("id") int id);

    @Select("SELECT * FROM admission_info WHERE id=#{id}")
    AdmissionInfo getAdmissionInfo(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO admission_info(entrant_id, level_of_education, direction, budget, contract, targeted_training, quota," +
            " consent_budget, consent_target, consent_quote ) " +
            "VALUES(#{admissionInfo.entrantId},#{admissionInfo.levelOfEducation},#{admissionInfo.direction}," +
            "#{admissionInfo.budget},#{admissionInfo.contract},#{admissionInfo.targetedTraining},#{admissionInfo.quota},#{admissionInfo.consentBudget}," +
            "#{admissionInfo.consentTarget},#{admissionInfo.consentQuote})")
    long save(@Param("admissionInfo") AdmissionInfo admissionInfo);

    @Options( keyProperty = "id", keyColumn = "id")
    @Update("UPDATE admission_info SET level_of_education=#{admissionInfo.levelOfEducation}, " +
            "direction=#{admissionInfo.direction}, budget=#{admissionInfo.budget}, contract=#{admissionInfo.contract}, " +
            "targeted_training=#{admissionInfo.targetedTraining}, quota=#{admissionInfo.quota} " +
            "WHERE id=#{admissionInfo.id}")
    long update(@Param("admissionInfo") AdmissionInfo admissionInfo);

    @Options( keyProperty = "id", keyColumn = "id")
    @Delete("DELETE from admission_info " +
            "WHERE id=#{id}")
    long delete(@Param("id") int id);

    @Options( keyProperty = "id", keyColumn = "id")
    @Update("UPDATE admission_info SET consent_budget=#{admissionInfo.consentBudget}, " +
            "consent_target=#{admissionInfo.consentTarget}, consent_quote=#{admissionInfo.consentQuote} " +
            "WHERE id=#{admissionInfo.id}")
    long updateConsent(@Param("admissionInfo") AdmissionInfo admissionInfo);
}