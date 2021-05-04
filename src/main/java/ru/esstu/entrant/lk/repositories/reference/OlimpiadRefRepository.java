package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.Olimpiad;

import java.util.List;
@Mapper
public interface OlimpiadRefRepository {
    @Select("SELECT * FROM public.olimpiad")
    List<Olimpiad> getOlimpiads();
}
