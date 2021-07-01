package ru.esstu.entrant.lk.services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.esstu.entrant.lk.api.notification.FirebaseNotification;
import ru.esstu.entrant.lk.api.notification.FirebaseResponse;

@Service
public class PushNotificationService {

    private static final String FIREBASE_SERVER_KEY = "AAAAxu5p3YY:APA91bFTxSuTtrhMBwEyq-9BnCpwGWtWMTsH9U-rwL621yiF9URS_os2mxEDkMo397X0OGkoNg7BlHaPU-Y4GbIGBcKeDSUh4nhOScEhTfasZQNiCiiVpnOIuvOg529Rb6W-8qw-w5tUly9YLmSmG6b71n4vafOF_A";

    public FirebaseResponse send(FirebaseNotification firebaseNotification) {
        return this.send(new HttpEntity<>(firebaseNotification.toJSON()));
    }

    public FirebaseResponse send(HttpEntity<String> entity) {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
        restTemplate.setInterceptors(interceptors);
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate.postForObject("https://fcm.googleapis.com/fcm/send", entity, FirebaseResponse.class);
    }

    public class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {

        private final String headerName;
        private final String headerValue;

        public HeaderRequestInterceptor(String headerName, String headerValue) {
            this.headerName = headerName;
            this.headerValue = headerValue;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            HttpRequest wrapper = new HttpRequestWrapper(request);
            wrapper.getHeaders().set(headerName, headerValue);
            return execution.execute(wrapper, body);
        }
    }
}
