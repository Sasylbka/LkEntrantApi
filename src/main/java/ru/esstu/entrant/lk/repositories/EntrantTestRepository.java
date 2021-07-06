package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.vo.EntrantTest;

import java.util.List;

@Mapper
public interface EntrantTestRepository {
    @Select("SELECT "+
            "entrant_test.login.username, "+
            "entrant_test.login.password_text, "+
            "public.exam_table.exam_date, "+
            "public.discipline.disc_name, "+
            "entrant_test.login.start_test_time, "+
            "entrant_test.login.enabled "+
            "FROM "+
            "entrant_test.login, public.exam_table, public.discipline " +
            "WHERE entrant_test.login.exam_code=public.exam_table.exam_id " +
            "and public.exam_table.disc_id=public.discipline.disc_id " +
            "and entrant_test.login.entrant_code=#{personId}")
    List<EntrantTest> getEntrantTest(@Param("personId") String personId);

}
