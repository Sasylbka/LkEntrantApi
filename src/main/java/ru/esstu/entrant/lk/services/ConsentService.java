package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.LocalDateType;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.async.NotificationAsync;
import ru.esstu.entrant.lk.domain.dto.AdmissionInfoDto;
import ru.esstu.entrant.lk.domain.dto.ConfigurationDto;
import ru.esstu.entrant.lk.domain.dto.ConsentDto;
import ru.esstu.entrant.lk.domain.mappers.AdmissionInfoMapper;
import ru.esstu.entrant.lk.domain.mappers.ConfigurationMapper;
import ru.esstu.entrant.lk.domain.mappers.ConsentMapper;
import ru.esstu.entrant.lk.domain.vo.AdmissionInfo;
import ru.esstu.entrant.lk.domain.vo.Consent;
import ru.esstu.entrant.lk.exceptions.PermissionDeniedException;
import ru.esstu.entrant.lk.repositories.AdmissionInfoRepository;
import ru.esstu.entrant.lk.repositories.ConfigurationRepository;
import ru.esstu.entrant.lk.repositories.ConsentRepository;

import java.lang.module.Configuration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ConsentService {

    private final ConsentRepository consentRepository;
    private final ConsentMapper consentMapper;
    private final AdmissionInfoRepository admissionInfoRepository;
    private final AdmissionInfoMapper admissionInfoMapper;
    private final AccessService accessService;
    private final ConfigurationRepository configurationRepository;
    private final NotificationAsync notificationAsync;


    public ConsentService(ConsentRepository consentRepository,
                          ConsentMapper consentMapper,
                          AccessService accessService,
                          AdmissionInfoRepository admissionInfoRepository,
                          AdmissionInfoMapper admissionInfoMapper,
                          ConfigurationRepository configurationRepository,
                          NotificationAsync notificationAsync
    ) {
        this.consentRepository = consentRepository;
        this.consentMapper = consentMapper;
        this.admissionInfoMapper = admissionInfoMapper;
        this.admissionInfoRepository = admissionInfoRepository;
        this.accessService = accessService;
        this.configurationRepository = configurationRepository;
        this.notificationAsync = notificationAsync;
    }

    public List<ConsentDto> getConsent(final int id) {//Получить историю согласия энтранта
        accessService.commonAccessCheck(id);
        return consentMapper.toDtos(consentRepository.getConsent(id));
    }

    public int getCount(final int id) {//Получить историю согласия энтранта
        accessService.commonAccessCheck(id);
        List<ConsentDto> temp = getFullAdd(id);//Лист истории добавлений
        return configurationRepository.getConfiguration().getMaxWithdrawalOfConsent() - temp.size();
    }

    public int getMaxWithdrawalOfConsent(final int id) {//Получить историю согласия энтранта
        accessService.commonAccessCheck(id);
        return configurationRepository.getConfiguration().getMaxWithdrawalOfConsent();
    }

    public List<ConsentDto> getFullAdd(final int id) {//Получить историю согласия только с add.
        accessService.commonAccessCheck(id);

        return consentMapper.toDtos(consentRepository.getFullAdd(id));
    }

    public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }

    public ConsentDto save(final ConsentDto consentDto) { //Добавить в историю запросов на согласие
        accessService.commonAccessCheck(consentDto.getEntrantId());
        Consent entity = consentMapper.toVO(consentDto);
        consentRepository.save(entity);
        return consentMapper.toDto(entity);
    }

    public void add(final AdmissionInfoDto admissionInfoDto) {//Добавление согласия
        accessService.commonAccessCheck(admissionInfoDto.getEntrantId());
        //Проверка на количество доступных подач согласий
        List<ConsentDto> temp = getFullAdd(admissionInfoDto.getEntrantId());//Лист истории добавлений
        List<AdmissionInfo> tempAI = admissionInfoRepository.getAdmissionInfos(admissionInfoDto.getEntrantId());//Лист всех направлений entrant-а
        AdmissionInfo entity = admissionInfoMapper.toVO(admissionInfoDto);//Выбранное направление для согласия
        int count = configurationRepository.getConfiguration().getMaxWithdrawalOfConsent() - temp.size();//Количество доступных подач согласий
        if (count > 0) {
            //Проверка admissionInfo на уже имеющееся согласие
            for (AdmissionInfo admissionInfo : tempAI) {
                //Проверка на наличие согласия у других направлений
                if (admissionInfo.isConsentBudget() || admissionInfo.isConsentTarget() || admissionInfo.isConsentQuote()) {
                    throw new PermissionDeniedException(
                            "У вас уже выбрано другое согласие. Пожалуйста, отзовите прошлое согласие и попробуйте снова.");
                }
            }
            //Добавление согласия
            saveConsent(admissionInfoMapper.toDto(entity));
            //Запись в историю
            LocalDateTime localDateTime = LocalDateTime.now();
            Date date = convertToDateViaSqlTimestamp(localDateTime);
            ConsentDto consentDto = new ConsentDto(0, admissionInfoDto.getEntrantId(), admissionInfoDto.getId(), date, "ADD");
            Consent entityC = consentMapper.toVO(consentDto);
            consentRepository.save(entityC);
            notificationAsync.sendNotificationStatusConsentChanged(entityC);
        } else {
            throw new PermissionDeniedException(
                    "У вас кончились попытки для подачи заявления о согласии.");
        }
    }

    public AdmissionInfoDto saveConsent(final AdmissionInfoDto admissionInfoDto) { //Добавить согласие в admissionInfo
        accessService.commonAccessCheck(admissionInfoDto.getEntrantId());
        AdmissionInfo entity = admissionInfoMapper.toVO(admissionInfoDto);
        admissionInfoRepository.updateConsent(entity);
        return admissionInfoMapper.toDto(entity);
    }

    public AdmissionInfoDto cancelConsent(final AdmissionInfoDto admissionInfoDto) { //Отмена заявления о согласии на зачисление
        accessService.commonAccessCheck(admissionInfoDto.getEntrantId());
        //Очистка согласия в AdmissionInfo
        AdmissionInfo entity = admissionInfoMapper.toVO(admissionInfoDto);
        entity.setConsentBudget(false);
        entity.setConsentQuote(false);
        entity.setConsentTarget(false);
        admissionInfoRepository.updateConsent(entity);
        //Добавление в историю запросов
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = convertToDateViaSqlTimestamp(localDateTime);
        ConsentDto consentDto = new ConsentDto(0, admissionInfoDto.getEntrantId(), admissionInfoDto.getId(), date, "CANCEL");
        Consent entityC = consentMapper.toVO(consentDto);
        //Сохранение в историю запросов
        consentRepository.save(entityC);
        notificationAsync.sendNotificationStatusConsentChanged(entityC);
        return admissionInfoMapper.toDto(entity);
    }
}