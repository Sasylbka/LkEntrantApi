package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.ContactInformationDto;
import ru.esstu.entrant.lk.domain.mappers.ContactInformationMapper;
import ru.esstu.entrant.lk.domain.vo.ContactInformation;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.repositories.ContactInformationRepository;

@Service
@Slf4j
public class ContactInformationService {

    private final ContactInformationRepository contactInformationRepository;
    private final ContactInformationMapper contactInformationMapper;

    public ContactInformationService(ContactInformationRepository contactInformationRepository,
                                ContactInformationMapper contactInformationMapper) {
        this.contactInformationRepository = contactInformationRepository;
        this.contactInformationMapper = contactInformationMapper;
    }


    public ContactInformationDto getContactInformation(final String id) {
        return contactInformationMapper.toDto(contactInformationRepository.getContactInformation(id));
//        return new TestTableDto(1, "NTCN");

    }
    public ContactInformation postContactInformation(final String id, final String mobile_number) {
        return contactInformationMapper.toVO(contactInformationRepository.postContactInformation(id,mobile_number));
    }

}