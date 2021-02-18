package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.TestTableDto;
import ru.esstu.entrant.lk.domain.mappers.TestTableMapper;
import ru.esstu.entrant.lk.repositories.TestTableRepository;

@Service
@Slf4j
public class TestTableService {

    private final TestTableRepository testTableRepository;
    private final TestTableMapper testTableMapper;

    public TestTableService(TestTableRepository testTableRepository,
                            TestTableMapper testTableMapper) {
        this.testTableRepository = testTableRepository;
        this.testTableMapper = testTableMapper;
    }

    public TestTableDto getTestTable(final int id) {
        return testTableMapper.toDto(testTableRepository.getTestTable(id));
//        return new TestTableDto(1, "NTCN");
    }
}
