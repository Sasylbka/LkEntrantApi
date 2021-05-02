package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;

@Mapper
public interface AdditionalInformationRepository {
    @Select("SELECT * FROM additional_information WHERE id = #{id}")
    AdditionalInformation getAdditionalInformation(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO additional_information(entrant_id, index, region, area, city, street, number_of_building, number_of_apartments) " +
            "VALUES(#{additionalInformation.entrantId},#{additionalInformation.index},#{additionalInformation.region},#{additionalInformation.area}," +
            "#{additionalInformation.city},#{additionalInformation.street},#{additionalInformation.number_of_building}," +
            "#{additionalInformation.number_of_apartments})")
    long save(@Param("additionalInformation") AdditionalInformation additionalInformation);
}