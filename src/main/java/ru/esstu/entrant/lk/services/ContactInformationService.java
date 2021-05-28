package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.ContactInformationDto;
import ru.esstu.entrant.lk.domain.mappers.ContactInformationMapper;
import ru.esstu.entrant.lk.domain.vo.ContactInformation;
import ru.esstu.entrant.lk.repositories.ContactInformationRepository;

@Service
@Slf4j
public class ContactInformationService {

    private final ContactInformationRepository contactInformationRepository;
    private final ContactInformationMapper contactInformationMapper;
    private final AccessService accessService;

    public ContactInformationService(ContactInformationRepository contactInformationRepository,
                                     ContactInformationMapper contactInformationMapper,
                                     AccessService accessService) {
        this.contactInformationRepository = contactInformationRepository;
        this.contactInformationMapper = contactInformationMapper;
        this.accessService = accessService;
    }

    public ContactInformationDto getContactInformation(final int id) {
        accessService.commonAccessCheck(id);
        ContactInformationDto contactInformationDto=contactInformationMapper.toDto(contactInformationRepository.getContactInformation(id));
        if(contactInformationDto==null){
            ContactInformationDto temp=new ContactInformationDto();
            return temp;
        }
        return contactInformationDto;
    }
    public ContactInformationDto save(final ContactInformationDto contactInformationDto) {
        accessService.commonAccessCheck(contactInformationDto.getEntrantId());
        ContactInformation entity = contactInformationMapper.toVO(contactInformationDto);
        contactInformationRepository.save(entity);
        return contactInformationMapper.toDto(entity);
    }
    public ContactInformationDto update(final ContactInformationDto contactInformationDto) {
        accessService.commonAccessCheck(contactInformationDto.getEntrantId());
        ContactInformation entity = contactInformationMapper.toVO(contactInformationDto);
        contactInformationRepository.update(entity);
        return contactInformationMapper.toDto(entity);
    }

}