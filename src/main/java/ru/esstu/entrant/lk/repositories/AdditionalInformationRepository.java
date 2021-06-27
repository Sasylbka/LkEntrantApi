package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;
import ru.esstu.entrant.lk.domain.vo.Entrant;

import java.util.List;

@Mapper
public interface AdditionalInformationRepository {
    @Select("SELECT * FROM additional_information WHERE entrant_id = #{id} order by type")
    List<AdditionalInformation> getAdditionalInformation(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO additional_information(entrant_id, index, region, area, city, street, number_of_building, number_of_apartments, type, coincides) " +
            "VALUES(#{additionalInformation.entrantId},#{additionalInformation.index},#{additionalInformation.region},#{additionalInformation.area}," +
            "#{additionalInformation.city},#{additionalInformation.street},#{additionalInformation.numberOfBuilding}," +
            "#{additionalInformation.numberOfApartments},#{additionalInformation.type},#{additionalInformation.coincides})")
    long save(@Param("additionalInformation") AdditionalInformation additionalInformation);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE additional_information SET entrant_id=#{additionalInformation.entrantId}, index=#{additionalInformation.index}, " +
            "region=#{additionalInformation.region}, area=#{additionalInformation.area},city=#{additionalInformation.city}, " +
            "street=#{additionalInformation.street}, number_of_building=#{additionalInformation.numberOfBuilding}, " +
            "number_of_apartments=#{additionalInformation.numberOfApartments}, type=#{additionalInformation.type}, coincides=#{additionalInformation.coincides} " +
            "WHERE id=#{additionalInformation.id}")
    long update(@Param("additionalInformation") AdditionalInformation additionalInformation);

}