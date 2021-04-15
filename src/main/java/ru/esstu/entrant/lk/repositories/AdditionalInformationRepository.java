package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;

@Mapper
public interface AdditionalInformationRepository {
    @Select("SELECT * FROM additional_information WHERE id = #{id}")
    AdditionalInformation getAdditionalInformation(@Param("id") String id);
    @Insert("INSERT INTO additional_information VALUES('#{additionalInformation.id}','#{additionalInformation.index}','#{additionalInformation.region}','#{additionalInformation.area}','#{additionalInformation.city}','#{additionalInformation.street}','#{additionalInformation.number_of_building}','#{additionalInformation.number_of_apartments}')")
    AdditionalInformationDto postAdditionalInformation(@Param("entity") AdditionalInformation additionalInformation);
}