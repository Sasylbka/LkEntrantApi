package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.AdditionalInformation;

@Mapper
public interface AdditionalInformationRepository {
    @Select("SELECT * FROM additional_information WHERE id = #{id}")
    AdditionalInformation getAdditionalInformation(@Param("id") String id);
}