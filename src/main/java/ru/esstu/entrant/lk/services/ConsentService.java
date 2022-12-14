package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.esstu.entrant.lk.async.NotificationAsync;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.dto.ConsentDto;
import ru.esstu.entrant.lk.domain.mappers.AdmissionInfoMapper;
import ru.esstu.entrant.lk.domain.mappers.ConsentMapper;
import ru.esstu.entrant.lk.domain.vo.Additionals.Keycloak;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;
import ru.esstu.entrant.lk.domain.vo.Consent;
import ru.esstu.entrant.lk.domain.vo.PublicTables.Person;
import ru.esstu.entrant.lk.exceptions.PermissionDeniedException;
import ru.esstu.entrant.lk.repositories.*;
import ru.esstu.entrant.lk.repositories.PublicTables.PersonPTRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class
ConsentService {

    private final ConsentRepository consentRepository;
    private final ConsentMapper consentMapper;
    private final AdmissionInfoRepository admissionInfoRepository;
    private final AdmissionInfoMapper admissionInfoMapper;
    private final AccessService accessService;
    private final ConfigurationRepository configurationRepository;
    private final NotificationAsync notificationAsync;
    private final ImportConsentRepository importConsentRepository;
    private final EntrantRepository entrantRepository;
    private final PersonPTRepository personPTRepository;

    public ConsentService(ConsentRepository consentRepository,
                          ConsentMapper consentMapper,
                          AccessService accessService,
                          AdmissionInfoRepository admissionInfoRepository,
                          AdmissionInfoMapper admissionInfoMapper,
                          ConfigurationRepository configurationRepository,
                          NotificationAsync notificationAsync, ImportConsentRepository importConsentRepository, EntrantRepository entrantRepository, PersonPTRepository personPTRepository) {
        this.consentRepository = consentRepository;
        this.consentMapper = consentMapper;
        this.admissionInfoMapper=admissionInfoMapper;
        this.admissionInfoRepository=admissionInfoRepository;
        this.accessService = accessService;
        this.configurationRepository=configurationRepository;
        this.notificationAsync = notificationAsync;
        this.importConsentRepository = importConsentRepository;

        this.entrantRepository = entrantRepository;
        this.personPTRepository = personPTRepository;
    }
    public List<ConsentDto> getConsent(final int id) {//Получить историю согласия энтранта
        accessService.commonAccessCheck(id);
        List<ConsentDto> temp =  consentMapper.toDtos(consentRepository.getConsent(id));
        return temp;
    }
    public int getCount( final int id) {//Получить историю согласия энтранта
        accessService.commonAccessCheck(id);
        List<ConsentDto> temp=getFullAdd(id);//Лист истории добавлений
        int count=configurationRepository.getConfiguration().getMaxWithdrawalOfConsent()-temp.size();//Количество доступных подач согласий
        return count;
    }
    public int getMaxWithdrawalOfConsent(final int id) {//Получить историю согласия энтранта
        accessService.commonAccessCheck(id);
        int maxWithdrawalOfConsent=configurationRepository.getConfiguration().getMaxWithdrawalOfConsent();//Максимальное количество подач согласий
        return maxWithdrawalOfConsent;
    }
    public List<ConsentDto> getFullAdd(final int id) {//Получить историю согласия только с add.
        accessService.commonAccessCheck(id);
        List<ConsentDto> temp =  consentMapper.toDtos(consentRepository.getFullAdd(id));
        return temp;
    }
    public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }
    @Transactional
    public ConsentDto save(final ConsentDto consentDto) { //Добавить в историю запросов на согласие
        accessService.commonAccessCheck(consentDto.getEntrantId());
        Consent entity= consentMapper.toVO(consentDto);
        consentRepository.save(entity);
        return consentMapper.toDto(entity);
    }
    @Transactional
    public AdmissionInfoDto add(final AdmissionInfoDto admissionInfoDto) {//Добавление согласия
        accessService.commonAccessCheck(admissionInfoDto.getEntrantId());
        if(!entrantRepository.getEntrant(admissionInfoDto.getEntrantId()).getStatus().equals("ACCEPTED"))
        {
            throw new PermissionDeniedException(
                    "Ваша заявка еще не принята. Попробуйте позже.");
        }
        //Проверка на количество доступных подач согласий
        List<ConsentDto> temp=getFullAdd(admissionInfoDto.getEntrantId());//Лист истории добавлений
        List<AdmissionInfo> tempAI=admissionInfoRepository.getAdmissionInfos(admissionInfoDto.getEntrantId());//Лист всех направлений entrant-а
        AdmissionInfo entity= admissionInfoMapper.toVO(admissionInfoDto);//Выбранное направление для согласия
        int count=configurationRepository.getConfiguration().getMaxWithdrawalOfConsent()-temp.size();//Количество доступных подач согласий
        if(count>0) {
            //Проверка admissionInfo на уже имеющееся согласие
            for(int i=0;i<tempAI.size();i++)
            {
                //Проверка на наличие согласия у других направлений
                if(tempAI.get(i).isConsentBudget()==true||tempAI.get(i).isConsentTarget()==true||tempAI.get(i).isConsentQuote()==true)

                {
                    throw new PermissionDeniedException(
                            "У вас уже выбрано другое согласие. Пожалуйста, отзовите прошлое согласие и попробуйте снова.");
                }
            }
            //Добавление согласия
            saveConsent(admissionInfoMapper.toDto(entity));
            Keycloak keycloak = entrantRepository.getKeycloakGuid(entity.getEntrantId());
            Person person = personPTRepository.getPerson(keycloak.getKeycloakGuid());
            //Запись в историю
            LocalDateTime localDateTime = LocalDateTime.now();
            Date date = convertToDateViaSqlTimestamp(localDateTime);
            String formOfFin="";
            if(entity.isConsentBudget()) { formOfFin="Бюджет";}
            if(entity.isConsentQuote()) { formOfFin="Особые права";}
            if(entity.isConsentTarget()) { formOfFin="Целевое";}
            ConsentDto consentDto = new ConsentDto(0, admissionInfoDto.getEntrantId(), admissionInfoDto.getId(),formOfFin, date, "ADD");
            Consent entityC = consentMapper.toVO(consentDto);
            consentRepository.save(entityC);
            notificationAsync.sendNotificationStatusConsentChanged(entityC);
            importConsentRepository.ReceiveOriginalDocument(true, person.getPersonId(),Integer.parseInt(entity.getDirection()),date);
            return admissionInfoMapper.toDto(entity);
        }
        else {throw new PermissionDeniedException(
                "У вас кончились попытки для подачи заявления о согласии.");}
    }
    public AdmissionInfoDto saveConsent(final AdmissionInfoDto admissionInfoDto) { //Добавить согласие в admissionInfo
        accessService.commonAccessCheck(admissionInfoDto.getEntrantId());
        AdmissionInfo entity= admissionInfoMapper.toVO(admissionInfoDto);
        admissionInfoRepository.updateConsent(entity);
        return admissionInfoMapper.toDto(entity);
    }
    @Transactional
    public AdmissionInfoDto cancelConsent(final AdmissionInfoDto admissionInfoDto) { //Отмена заявления о согласии на зачисление
        accessService.commonAccessCheck(admissionInfoDto.getEntrantId());
        AdmissionInfo entity= admissionInfoMapper.toVO(admissionInfoDto);
        //Выделение формы финансирования
        String formOfFin="";
        if(entity.isConsentBudget()) { formOfFin="Бюджет";}
        if(entity.isConsentQuote()) { formOfFin="Особые права";}
        if(entity.isConsentTarget()) { formOfFin="Целевое";}
        //Очистка согласия в AdmissionInfo
        entity.setConsentBudget(false);
        entity.setConsentQuote(false);
        entity.setConsentTarget(false);
        Keycloak keycloak = entrantRepository.getKeycloakGuid(entity.getEntrantId());
        Person person = personPTRepository.getPerson(keycloak.getKeycloakGuid());
        admissionInfoRepository.updateConsent(entity);
        //Добавление в историю запросов
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = convertToDateViaSqlTimestamp(localDateTime);
        ConsentDto consentDto = new ConsentDto(0, admissionInfoDto.getEntrantId(), admissionInfoDto.getId(), formOfFin, date, "CANCEL");
        Consent entityC = consentMapper.toVO(consentDto);
        //Сохранение в историю запросов
        consentRepository.save(entityC);
        importConsentRepository.RevocationOriginalDocument(false, person.getPersonId(),Integer.parseInt(entity.getDirection()),date);
        return admissionInfoMapper.toDto(entity);
    }
}