package ru.esstu.entrant.lk.domain.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.domain.dto.TestTableDto;
import ru.esstu.entrant.lk.domain.vo.TestTable;

/**
 * Маппер.
 */
@Slf4j
@Component
public class TestTableMapper {

    /**
     * Преобразование.
     *
     * @param vo объект
     * @return dto
     */
    public TestTableDto toDto(TestTable vo) {
        if (vo == null) {
            return null;
        }
        return new TestTableDto(
                vo.getId(),
                vo.getTestText()
        );
    }

    /**
     * Преобразование.
     *
     * @param dto объект
     * @return dto
     */
    public TestTable toVO(TestTableDto dto) {
        if (dto == null) {
            return null;
        }
        return new TestTable(
                dto.getId(),
                dto.getTestText()
        );
    }
}
