package ru.esstu.entrant.lk.repositories.reference;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.reference.Region;

import java.util.List;

@Mapper
public interface RegionRefRepository {
    @Select("SELECT * FROM public.region")
    List<Region> getRegions();
}
