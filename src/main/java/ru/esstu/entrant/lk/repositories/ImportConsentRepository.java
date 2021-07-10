package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;

@Mapper
public interface ImportConsentRepository {
    @Update("Update public.entrance_info Set original_edu_document=#{status} where " +
            "entrant_id=#{entrant_id} and spec_id=#{spec_id}")
    long UpdateOriginalDocument(@Param("status") boolean status,@Param("entrant_id")String entrant_id,
                                @Param("spec_id")int spec_id);
}
