package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.dto.JobInformationDto;
import ru.esstu.entrant.lk.domain.vo.JobInformation;

@Mapper
public interface JobInformationRepository {
    @Select("SELECT * FROM job_information WHERE id = #{id}")
    JobInformation getJobInformation(@Param("id") String id);
    @Insert("INSERT INTO job_information VALUES('#{jobInformation.id}','#{jobInformation.place_of_job}','#{jobInformation.position}')")
    JobInformationDto postJobInformation(@Param("entity") JobInformation jobInformation);
}