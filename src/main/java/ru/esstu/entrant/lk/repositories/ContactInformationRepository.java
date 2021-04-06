package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.ContactInformation;

@Mapper
public interface ContactInformationRepository {
    @Select("SELECT * FROM contact_information WHERE id = #{id}")
    ContactInformation getContactInformation(@Param("id") String id);
}