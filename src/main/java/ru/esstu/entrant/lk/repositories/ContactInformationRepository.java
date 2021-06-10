package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.ContactInformation;

@Mapper
public interface ContactInformationRepository {
    @Select("SELECT * FROM contact_information WHERE entrant_id = #{id}")
    ContactInformation getContactInformation(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO contact_information(entrant_id, mobile_number, email) VALUES( #{contactInformation.entrantId}, #{contactInformation.mobileNumber}, " +
            "#{contactInformation.email})")
    long save(@Param("contactInformation") ContactInformation contactInformation);

    @Options(keyProperty = "id", keyColumn = "id")
    @Update("UPDATE contact_information SET mobile_number=#{contactInformation.mobileNumber}, email=#{contactInformation.email} " +
            "WHERE entrant_id=#{contactInformation.entrantId}")
    long update(@Param("contactInformation") ContactInformation contactInformation);
}