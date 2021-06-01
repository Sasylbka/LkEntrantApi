package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.Olympiad;

import java.util.List;
@Mapper
public interface OlympiadRefRepository {
    @Select("SELECT * FROM public.olimpiad")
    List<Olympiad> getOlympiads();
}
