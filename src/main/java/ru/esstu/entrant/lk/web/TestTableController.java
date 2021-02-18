package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.TestTableDto;
import ru.esstu.entrant.lk.services.TestTableService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class TestTableController {

    /**
     * Сервис.
     */
    private final TestTableService testTableService;

    public TestTableController(TestTableService testTableService) {
        this.testTableService = testTableService;
    }

    /**
     * Тест.
     *
     * @param id ИД
     * @return ответ
     */
    @RequestMapping(method = RequestMethod.GET, path = "/testTable")
    public TestTableDto test(final Integer id) {
        return testTableService.getTestTable(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/testTable2")
    public TestTableDto test2(final Integer id) {
        return new TestTableDto(1, "TESXT");
    }
}
