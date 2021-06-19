package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.Citizenhood;

import java.util.List;
@Mapper
public interface CitizenhoodRefRepository {
    @Select("SELECT * FROM public.citizenhood")
    List<Citizenhood> getCitizenhoods();
}
