package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.EntrantPrivateDataDto;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;

@Mapper
public interface EntrantPrivateDataRepository {
    @Select("SELECT * FROM entrant_private_data WHERE id = #{id}")
    EntrantPrivateData getEntrantPrivateData(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO entrant_private_data(entrantId, name, family_name, patronymic, gender, date_of_birth, city_of_birth, region_of_birth) " +
            "VALUES(#{entrantPrivateData.entrantId},#{entrantPrivateData.name},#{entrantPrivateData.family_name},#{entrantPrivateData.patronymic}," +
            "#{entrantPrivateData.gender},#{entrantPrivateData.date_of_birth},#{entrantPrivateData.city_of_birth},#{entrantPrivateData.region_of_birth})")
    long save(@Param("entrantPrivateData") EntrantPrivateData entrantPrivateData);
}
