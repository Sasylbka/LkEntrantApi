package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.JobInformationDto;
import ru.esstu.entrant.lk.domain.vo.JobInformation;

@Mapper
public interface JobInformationRepository {
    @Select("SELECT * FROM job_information WHERE entrant_id = #{id}")
    JobInformation getJobInformation(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO job_information(entrantId, place_of_job, position) VALUES(#{jobInformation.entrantId}," +
            "#{jobInformation.placeOfJob},#{jobInformation.position})")
    long save(@Param("jobInformation") JobInformation jobInformation);

    @Options(useGeneratedKeys = false, keyProperty = "id", keyColumn = "id")
    @Update("UPDATE job_information SET " +
            "place_of_job=#{jobInformation.placeOfJob}, position=#{jobInformation.position} WHERE entrant_id=#{jobInformation.entrantId}")
    long update(@Param("jobInformation") JobInformation jobInformation);
}