package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.ParentsInformationDto;
import ru.esstu.entrant.lk.domain.vo.ParentsInformation;
import ru.esstu.entrant.lk.services.ParentsInformationService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class ParentsInformationController {

    /**
     * Сервис.
     */
    private final ParentsInformationService parentsInformationService;

    public ParentsInformationController(ParentsInformationService ParentsInformationService) {
        this.parentsInformationService = ParentsInformationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/ParentsInformation")
    public ParentsInformationDto test(final String id) {

        return parentsInformationService.getParentsInformation(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/ParentsInformation")
    public ParentsInformation post(final String id, final String father_mobile_number , final String father_name,final String father_second_name,final String father_patronymic,final String place_of_father_job,final String mother_mobile_number,final String mother_name,final String mother_second_name,final String mother_patronymic,final String place_of_mother_job,final String additional_phone_number) {
        return parentsInformationService.postParentsInformation(id,father_mobile_number,father_name,father_second_name,father_patronymic,place_of_father_job,mother_mobile_number,mother_name,mother_second_name,mother_patronymic,place_of_mother_job,additional_phone_number);
    }
}
