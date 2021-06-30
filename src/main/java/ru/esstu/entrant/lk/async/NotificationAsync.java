package ru.esstu.entrant.lk.async;

import org.jooq.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import ru.esstu.entrant.lk.api.notification.FirebaseNotification;
import ru.esstu.entrant.lk.api.notification.FirebaseResponse;
import ru.esstu.entrant.lk.domain.vo.Dialog;
import ru.esstu.entrant.lk.domain.vo.Message;
import ru.esstu.entrant.lk.domain.vo.UsersGoogleFcm;
import ru.esstu.entrant.lk.services.PushNotificationService;
import ru.esstu.entrant.lk.services.UserFCMService;

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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
                 System.out.println(notification.toJSON());
                FirebaseResponse firebaseResponse = pushNotificationService.send(new HttpEntity<>(notification.toJSON()));
                if (firebaseResponse.getFailure() > 0) {
                    userFCMService.removeToken(userFCM);
                }
            }
        }
    }

}
