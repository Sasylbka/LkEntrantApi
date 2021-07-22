package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;

import java.util.Date;

@Mapper
public interface ImportConsentRepository {
    @Update("Update public.entrance_info Set original_edu_document=#{status}, original_recieve_date=#{date} where " +
            "entrant_id=#{entrant_id} and spec_id=#{spec_id}")
    long ReceiveOriginalDocument(@Param("status") boolean status,@Param("entrant_id")String entrant_id,
                                @Param("spec_id")int spec_id,@Param("date") Date date);
    @Update("Update public.entrance_info Set original_edu_document=#{status}, original_revocation_date=#{date} where " +
            "entrant_id=#{entrant_id} and spec_id=#{spec_id}")
    long RevocationOriginalDocument(@Param("status") boolean status,@Param("entrant_id")String entrant_id,
                                 @Param("spec_id")int spec_id,@Param("date")Date date);
}
