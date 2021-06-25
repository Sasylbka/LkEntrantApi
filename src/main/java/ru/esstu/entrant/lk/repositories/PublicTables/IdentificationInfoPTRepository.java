package ru.esstu.entrant.lk.repositories.PublicTables;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Entrant;
import ru.esstu.entrant.lk.domain.vo.PublicTables.IdentificationInfo;
@Mapper
public interface IdentificationInfoPTRepository {
    @Select("SELECT entrant_id From public.identification_info where doc_series=#{serial} and doc_number=#{number}")
    IdentificationInfo getEntrant(@Param("serial")String serial, @Param("number")String number);
}
