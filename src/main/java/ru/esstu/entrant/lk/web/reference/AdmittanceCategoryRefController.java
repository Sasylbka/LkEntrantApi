package ru.esstu.entrant.lk.web.reference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.reference.AdmittanceCategoryDto;
import ru.esstu.entrant.lk.services.reference.AdmittanceCategoryRefService;

import java.util.List;

@RestController
@Slf4j
public class AdmittanceCategoryRefController {
    /**
     * Сервис.
     */
    private final AdmittanceCategoryRefService admittanceCategoryRefService;

    public AdmittanceCategoryRefController(AdmittanceCategoryRefService admittanceCategoryRefService) {
        this.admittanceCategoryRefService = admittanceCategoryRefService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reference/admittanceCategory")
    public List<AdmittanceCategoryDto> get() {
        return admittanceCategoryRefService.getAdmittanceCategories();
    }
}
