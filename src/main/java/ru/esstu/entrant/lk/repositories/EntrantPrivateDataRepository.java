package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.dto.EntrantPrivateDataDto;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;

@Mapper
public interface EntrantPrivateDataRepository {
    @Select("SELECT * FROM entrant_private_data WHERE id = #{id}")
    EntrantPrivateData getEntrantPrivateData(@Param("id") String id);
    @Insert("INSERT INTO job_information VALUES('#{id}','#{name}','#{family_name}','#{patronymic}','#{gender}','#{date_of_birth}','#{city_of_birth}','#{region_of_birth}')")
    EntrantPrivateDataDto postEntrantPrivateData(@Param("id") String id, @Param("name") String name, @Param("family_name") String family_name, @Param("patronymic") String patronymic, @Param("gender") String gender, @Param("date_of_birth") String date_of_birth, @Param("city_of_birth") String city_of_birth, @Param("region_of_birth") String region_of_birth);
}
