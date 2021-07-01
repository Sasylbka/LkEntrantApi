package ru.esstu.entrant.lk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.esstu.entrant.lk.domain.vo.UsersGoogleFcm;
import ru.esstu.entrant.lk.repositories.GoogleFcmRepository;

@Service
@Transactional
public class UserFCMService {

    private final GoogleFcmRepository googleFcmRepository;

    @Autowired
    UserFCMService(GoogleFcmRepository googleFcmRepository) {
        this.googleFcmRepository = googleFcmRepository;
    }

    public void tokenRegistry(String userId, String platform, String token) {
        UsersGoogleFcm userFCM = googleFcmRepository.findByUserId(userId);
        if (userFCM == null) {
            userFCM = new UsersGoogleFcm();
            userFCM.setUserId(userId);
            userFCM.setPlatform(platform);
            userFCM.setToken(token);
            googleFcmRepository.save(userFCM);
        } else {
            userFCM.setPlatform(platform);
            userFCM.setToken(token);
            googleFcmRepository.update(userFCM);
        }
    }

    public void tokenUpdate(String userId, String platform, String token) {
        this.tokenRegistry(userId, platform, token);
    }

    public UsersGoogleFcm getTokenByUser(String userId) {
        return googleFcmRepository.findByUserId(userId);
    }

    public void removeToken(UsersGoogleFcm userFCM) {
         googleFcmRepository.delete(userFCM.getId());
    }
}
