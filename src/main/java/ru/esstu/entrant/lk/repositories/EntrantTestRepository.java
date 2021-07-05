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
            "entrant_test.login "+
            "Left join public.exam_table on entrant_test.login.exam_code=public.exam_table.exam_id " +
            "left join public.discipline on public.exam_table.disc_id=public.discipline.disc_id " +
            "left join public.person on entrant_test.login.entrant_code=public.person.person_id")
    List<EntrantTest> getEntrantTest();

}
