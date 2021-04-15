package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.dto.ContactInformationDto;
import ru.esstu.entrant.lk.domain.vo.ContactInformation;

@Mapper
public interface ContactInformationRepository {
    @Select("SELECT * FROM contact_information WHERE id = #{id}")
    ContactInformation getContactInformation(@Param("id") String id);
    @Insert("INSERT INTO contact_information VALUES('#{contactInformation.id}','#{contactInformation.mobile_number}')")
    ContactInformationDto postContactInformation(@Param("entity") ContactInformation contactInformation);

}