package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.domain.vo.BenefitInformation;

@Mapper
public interface BenefitInformationRepository {
    @Select("SELECT * FROM benefit_information WHERE id = #{id}")
    BenefitInformation getBenefitInformation(@Param("id") String id);
    @Insert("INSERT INTO benefit_information VALUES('#{benefitInformation.id}','#{benefitInformation.reason_for_the_benefit}','#{benefitInformation.document_for_the_benefit}','#{benefitInformation.serial_number_document_for_the_benefit}','#{benefitInformation.issued_by}','#{benefitInformation.data_of_issued}')")
    BenefitInformationDto postBenefitInformation(@Param("entity") BenefitInformation benefitInformation);

}