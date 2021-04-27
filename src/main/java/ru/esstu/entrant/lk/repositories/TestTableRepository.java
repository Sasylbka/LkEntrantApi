package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.esstu.entrant.lk.domain.vo.TestTable;

@Mapper
public interface TestTableRepository {
    @Select("SELECT * FROM public.test_table WHERE id = #{id}")
    TestTable getTestTable(@Param("id") Integer id);
}
