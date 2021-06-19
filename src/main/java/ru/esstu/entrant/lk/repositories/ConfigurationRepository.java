package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.Configuration;

@Mapper
public interface ConfigurationRepository {
    @Select("SELECT * FROM configuration WHERE id=1")
    Configuration getConfiguration();
}