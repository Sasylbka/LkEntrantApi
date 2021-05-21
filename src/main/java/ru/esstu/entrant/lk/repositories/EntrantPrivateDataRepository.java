package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.EntrantPrivateDataDto;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;

@Mapper
public interface EntrantPrivateDataRepository {
    @Select("SELECT * FROM entrant_private_data WHERE entrant_id = #{id}")
    EntrantPrivateData getEntrantPrivateData(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO entrant_private_data(entrant_id, name, family_name, patronymic, gender, date_of_birth, city_of_birth, region_of_birth, snills) " +
            "VALUES(#{entrantPrivateData.entrantId},#{entrantPrivateData.name},#{entrantPrivateData.familyName},#{entrantPrivateData.patronymic}," +
            "#{entrantPrivateData.gender},#{entrantPrivateData.dateOfBirth},#{entrantPrivateData.cityOfBirth},#{entrantPrivateData.regionOfBirth},#{entrantPrivateData.snills})")
    long save(@Param("entrantPrivateData") EntrantPrivateData entrantPrivateData);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE entrant_private_data SET " +
            "name=#{entrantPrivateData.name}, family_name=#{entrantPrivateData.familyName}, patronymic=#{entrantPrivateData.patronymic}, " +
            "gender=#{entrantPrivateData.gender}, date_of_birth=#{entrantPrivateData.dateOfBirth}, " +
            "city_of_birth=#{entrantPrivateData.cityOfBirth}, region_of_birth=#{entrantPrivateData.regionOfBirth}, snills=#{entrantPrivateData.snills} " +
            "WHERE entrant_id=#{entrantPrivateData.entrantId}")
    long update(@Param("entrantPrivateData") EntrantPrivateData entrantPrivateData);
}
