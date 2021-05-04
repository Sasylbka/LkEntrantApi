package ru.esstu.entrant.lk.web.reference;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.esstu.entrant.lk.domain.dto.reference.RegionDto;
import ru.esstu.entrant.lk.services.reference.RegionRefService;

import java.util.List;

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
