package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.DistrictDto;
import ru.esstu.entrant.lk.services.reference.DistrictRefService;

import java.util.List;
@RestController
@Slf4j
public class DistrictRefController {
    private final DistrictRefService districtRefService;

    public DistrictRefController(DistrictRefService districtRefService) {
        this.districtRefService = districtRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/district")
    public List<DistrictDto> get() {
        return districtRefService.getDistricts();
    }
}
