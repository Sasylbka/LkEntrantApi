package ru.esstu.entrant.lk.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.api.notification.FirebaseNotification;
import ru.esstu.entrant.lk.api.notification.FirebaseResponse;
import ru.esstu.entrant.lk.domain.vo.*;
import ru.esstu.entrant.lk.services.PushNotificationService;
import ru.esstu.entrant.lk.services.UserFCMService;

import java.util.Date;

@Component
@EnableAsync
public class NotificationAsync {

    UserFCMService userFCMService;
    PushNotificationService pushNotificationService;


    @Autowired
    NotificationAsync(UserFCMService userFCMService, PushNotificationService pushNotificationService) {
        this.userFCMService = userFCMService;
        this.pushNotificationService = pushNotificationService;
    }

    @Async
    public void sendNotificationMessageAsync(Dialog dialog, Message sentMessage) {
        if (sentMessage.getSenderId() != dialog.getEntrantId()) {
            UsersGoogleFcm userFCM = userFCMService.getTokenByUser(Integer.toString(dialog.getEntrantId()));
            if (userFCM != null) {
                FirebaseNotification notification = new FirebaseNotification();
                notification.addRequestAttribute("content_available", true);
                notification.addRequestAttribute("mutable_content", true);
                notification.to(userFCM.getToken());
                notification.title("Новое сообщение от " + sentMessage.getSender());
                notification.tag("DIALOGUE");
                notification.addNotificationAttribute("dialog_id", dialog.getId());
                notification.addNotificationAttribute("time", sentMessage.getDate());
                notification.addNotificationAttribute("message_id", sentMessage.getId());
                notification.addNotificationAttribute("from_id", sentMessage.getSenderId());
                notification.text(sentMessage.getMessage());
                notification.sound("default");
//                 System.out.println(notification.toJSON());
                FirebaseResponse firebaseResponse = pushNotificationService.send(new HttpEntity<>(notification.toJSON()));
                if (firebaseResponse.getFailure() > 0) {
                    userFCMService.removeToken(userFCM);
                }
            }
        }
    }

    @Async
    public void sendNotificationStatusApplicationChanged(Entrant entrant) {
        UsersGoogleFcm userFCM = userFCMService.getTokenByUser(Integer.toString(entrant.getId()));
        FirebaseNotification notification = new FirebaseNotification();
        notification.addRequestAttribute("content_available", true);
        notification.addRequestAttribute("mutable_content", true);
        notification.to(userFCM.getToken());
        notification.tag("STATUS_APPLICATION");

        switch (entrant.getStatus()) {
            case "PROCESS_FILLING": notification.title("Ваше заявление в процессе заполнения"); break;
            case "SENT": notification.title("Ваше заявление отправлено на рассмотрение"); break;
            case "FAIL": notification.title("Ошибка при импорте заявления"); break;
            case "ACCEPTED": notification.title("Ваше заявление принято"); break;
            case "REJECTED": notification.title("Ваше заявление отклонено"); break;
        }

        Date date = new Date();
        notification.addNotificationAttribute("time", date.getTime());
        notification.sound("default");
        FirebaseResponse firebaseResponse = pushNotificationService.send(new HttpEntity<>(notification.toJSON()));
        if (firebaseResponse.getFailure() > 0) {
            userFCMService.removeToken(userFCM);
        }
    }

    @Async
    public void sendNotificationStatusConsentChanged(Consent consent) {
        UsersGoogleFcm userFCM = userFCMService.getTokenByUser(Integer.toString(consent.getEntrantId()));
        FirebaseNotification notification = new FirebaseNotification();
        notification.addRequestAttribute("content_available", true);
        notification.addRequestAttribute("mutable_content", true);
        notification.to(userFCM.getToken());
        notification.tag("STATUS_CONSENT");

        switch (consent.getActionType()) {
            case "ADD": notification.title("Ваше согласие принято"); break;
            case "CANCEL": notification.title("Ваше согласие отозвано"); break;
        }

        Date date = new Date();
        notification.addNotificationAttribute("time", date.getTime());
        notification.sound("default");
        FirebaseResponse firebaseResponse = pushNotificationService.send(new HttpEntity<>(notification.toJSON()));
        if (firebaseResponse.getFailure() > 0) {
            userFCMService.removeToken(userFCM);
        }
    }

}
