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
    @Insert("INSERT INTO entrant_private_data VALUES('#{entrantPrivateData.id}','#{entrantPrivateData.name}','#{entrantPrivateData.family_name}','#{entrantPrivateData.patronymic}','#{entrantPrivateData.gender}','#{entrantPrivateData.date_of_birth}','#{entrantPrivateData.city_of_birth}','#{entrantPrivateData.region_of_birth}')")
    EntrantPrivateDataDto postEntrantPrivateData(@Param("entity") EntrantPrivateData entrantPrivateData);
}
