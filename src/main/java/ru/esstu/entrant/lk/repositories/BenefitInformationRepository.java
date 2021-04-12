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
    @Insert("INSERT INTO job_information VALUES('#{id}','#{reason_for_the_benefit}','#{document_for_the_benefit}','#{serial_number_document_for_the_benefit}','#{issued_by}','#{data_of_issued}')")
    BenefitInformationDto postBenefitInformation(@Param("id") String id, @Param("reason_for_the_benefit") String reason_for_the_benefit, @Param("document_for_the_benefit") String document_for_the_benefit,@Param("serial_number_document_for_the_benefit") String serial_number_document_for_the_benefit,@Param("issued_by") String issued_by,@Param("data_of_issued") String data_of_issued);

}