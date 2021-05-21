package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.ContactInformation;
import ru.esstu.entrant.lk.domain.vo.Questionnaire;

import java.util.List;
@Mapper
public interface QuestionnaireRepository {
    @Select("SELECT " +
            "entrant_private_data.id, entrant_private_data.entrant_id, " +
            "entrant_private_data.name," +
            "entrant_private_data.family_name," +
            "entrant_private_data.patronymic, admission_info.level_of_education," +
            "changes_date.date_of_creation,changes_date.date_of_send,changes_date.date_of_answer," +
            "admission_info.contract, entrant.status " +
            "FROM " +
            "entrant_private_data, entrant, admission_info, changes_date " +
            "WHERE " +
            "entrant.id=entrant_private_data.entrant_id " +
            "and entrant.id=admission_info.entrant_id " +
            "and entrant.id=changes_date.entrant_id ")
    List<Questionnaire> getQuestionnaire();

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO questionnaire(entrant_id, status,additional) VALUES( #{questionnaire.entrantId}, #{questionnaire.status}, #{questionnaire.additional})")
    long save(@Param("contactInformation") ContactInformation contactInformation);
}
