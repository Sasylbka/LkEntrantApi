package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.dto.AdditionalInformationDto;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;

@Mapper
public interface AdditionalInformationRepository {
    @Select("SELECT * FROM additional_information WHERE id = #{id}")
    AdditionalInformation getAdditionalInformation(@Param("id") String id);
    @Insert("INSERT INTO job_information VALUES('#{id}','#{index}','#{region}','#{area}','#{city}','#{street}','#{number_of_building}','#{number_of_apartments}')")
    AdditionalInformationDto postAdditionalInformation(@Param("id") String id, @Param("index") String index, @Param("region") String region,@Param("area") String area,@Param("city") String city,@Param("street") String street,@Param("number_of_building") String number_of_building,@Param("number_of_apartments") String number_of_apartments);
}