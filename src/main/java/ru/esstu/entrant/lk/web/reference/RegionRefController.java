package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.RegionDto;
import ru.esstu.entrant.lk.services.reference.RegionRefService;

import java.util.List;
@RestController
@Slf4j
public class RegionRefController {
    /**
     * Сервис.
     */
    private final RegionRefService regionRefService;

    public RegionRefController(RegionRefService regionRefService) {
        this.regionRefService = regionRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/region")
    public List<RegionDto> get() {
        return regionRefService.getRegions();
    }
}
