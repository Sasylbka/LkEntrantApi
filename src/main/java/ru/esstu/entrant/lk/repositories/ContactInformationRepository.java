package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.ContactInformation;

@Mapper
public interface ContactInformationRepository {
    @Select("SELECT * FROM contact_information WHERE id = #{id}")
    ContactInformation getContactInformation(@Param("id") String id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO contact_information(entrant_id, mobile_number) VALUES( #{contactInformation.entrantId}, #{contactInformation.mobileNumber})")
    long save(@Param("contactInformation") ContactInformation contactInformation);

}