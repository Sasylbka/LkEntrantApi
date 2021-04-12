package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.BenefitInformationDto;
import ru.esstu.entrant.lk.domain.vo.BenefitInformation;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.services.BenefitInformationService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class BenefitInformationController {

    /**
     * Сервис.
     */
    private final BenefitInformationService BenefitInformationService;

    public BenefitInformationController(BenefitInformationService BenefitInformationService) {
        this.BenefitInformationService = BenefitInformationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/BenefitInformation")
    public BenefitInformationDto test(final String id) {

        return BenefitInformationService.getBenefitInformation(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/BenefitInformation")
    public BenefitInformation post(final String id, final String reason_for_the_benefit , final String document_for_the_benefit,final String serial_number_document_for_the_benefit,final String issued_by,final String data_of_issued) {
        return BenefitInformationService.postBenefitInformation(id,reason_for_the_benefit,document_for_the_benefit,serial_number_document_for_the_benefit,issued_by,data_of_issued);
    }
}
