package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.esstu.entrant.lk.api.notification.RequestFirebaseToken;
import ru.esstu.entrant.lk.services.UserFCMService;
import ru.esstu.entrant.lk.services.UserService;

@RestController
@Slf4j
public class FCMController {

    private final UserFCMService userFCMService;
    private final UserService userService;

    @Autowired
    FCMController(UserFCMService userFCMService, UserService userService) {
        this.userFCMService = userFCMService;
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = "/fcm/tokenRegistry", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> tokenRegistry(@RequestBody RequestFirebaseToken requestFirebaseToken) {
        try {
            userFCMService.tokenRegistry(Integer.toString(userService.getCurrentUser().getId()), requestFirebaseToken.getPlatform(), requestFirebaseToken.getToken());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @ResponseBody
    @RequestMapping(value = "/fcm/tokenUpdate", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> tokenUpdate(@RequestBody RequestFirebaseToken requestFirebaseToken) {
        try {
            userFCMService.tokenUpdate(Integer.toString(userService.getCurrentUser().getId()),  requestFirebaseToken.getPlatform(), requestFirebaseToken.getToken());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
