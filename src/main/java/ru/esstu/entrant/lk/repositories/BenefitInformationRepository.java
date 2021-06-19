package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.domain.vo.BenefitInformation;

@Mapper
public interface BenefitInformationRepository {
    @Select("SELECT * FROM benefit_information WHERE entrant_id = #{id}")
    BenefitInformation getBenefitInformation(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO benefit_information(entrant_id, reason_for_the_benefit, document_for_the_benefit, serial_number_of_document_for_the_benefit, issued_by, data_of_issued,benefit_checked) " +
            "VALUES(#{benefitInformation.entrantId},#{benefitInformation.reasonForTheBenefit},#{benefitInformation.documentForTheBenefit}," +
            "#{benefitInformation.serialNumberOfDocumentForTheBenefit},#{benefitInformation.issuedBy},#{benefitInformation.dataOfIssued},#{benefitInformation.benefitChecked})")
    long save(@Param("benefitInformation") BenefitInformation benefitInformation);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE benefit_information SET " +
            "reason_for_the_benefit=#{benefitInformation.reasonForTheBenefit}, document_for_the_benefit=#{benefitInformation.documentForTheBenefit}, " +
            "serial_number_of_document_for_the_benefit=#{benefitInformation.serialNumberOfDocumentForTheBenefit}, " +
            "issued_by=#{benefitInformation.issuedBy}, data_of_issued=#{benefitInformation.dataOfIssued},benefit_checked=#{benefitInformation.benefitChecked} WHERE entrant_id=#{benefitInformation.entrantId}")
    long update(@Param("benefitInformation") BenefitInformation benefitInformation);

}