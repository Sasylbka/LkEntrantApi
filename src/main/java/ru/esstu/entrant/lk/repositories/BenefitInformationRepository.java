package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.BenefitInformation;

@Mapper
public interface BenefitInformationRepository {
    @Select("SELECT * FROM benefit_information WHERE id = #{id}")
    BenefitInformation getBenefitInformation(@Param("id") String id);
}