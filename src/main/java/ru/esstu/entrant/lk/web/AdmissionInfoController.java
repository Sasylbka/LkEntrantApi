package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.services.AdmissionInfoService;

import java.util.List;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class AdmissionInfoController {

    /**
     * Сервис.
     */
    private final AdmissionInfoService admissionInfoService;

    public AdmissionInfoController(AdmissionInfoService admissionInfoService) {
        this.admissionInfoService = admissionInfoService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admissionInfo")
    public List<AdmissionInfoDto> get(final int id) {
       return admissionInfoService.getAdmissionInfo(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/admissionInfo")
    public AdmissionInfoDto save(@RequestBody final AdmissionInfoDto admissionInfoDto) {
        return admissionInfoService.save(admissionInfoDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/admissionInfo")
    public void delete(final int id) {
        admissionInfoService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/admissionInfo")
    public AdmissionInfoDto update(@RequestBody final AdmissionInfoDto admissionInfoDto) {
        return admissionInfoService.update(admissionInfoDto);
    }

}
