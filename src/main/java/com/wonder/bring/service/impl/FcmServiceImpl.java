package com.wonder.bring.service.impl;

import com.wonder.bring.service.FcmService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class FcmServiceImpl implements FcmService {
    private final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
    private final String FIREBASE_SERVER_KEY = "AAAAJSPI87c:APA91bHi3ezgNCH4BgFIMYW8IOoL2pghYZIH8LZPSnmqd2qwm8Q7iT-Gs3LPG6ZwAkSCt4bOQTu4FNea8DKC_k1PG-rITS01uI45TFddedgko7I3Fx3knKqO8Iq7cCB-K49e0xmGCayR";

    @Override
    public void sendPush(final String fcmToken, final String title, final String body) {
        JSONObject msg = new JSONObject();

        //타이틀과 내용을 db에서 갖고와서 넣을것
        msg.put("title", title);
        msg.put("body", body);

        String response = callToFcmServer(msg, fcmToken); //파이어베이스 서버에 요청
        System.out.println("Got response from fcm Server : " + response + "\n\n");

    }

    private String callToFcmServer(JSONObject message, String receiverFcmKey) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "key=" + FIREBASE_SERVER_KEY);
        httpHeaders.set("Content-Type", "application/json");

        JSONObject json = new JSONObject();

        json.put("notification", message);
        json.put("to", receiverFcmKey);

        System.out.println("Sending :" + json.toString());

        HttpEntity<String> httpEntity = new HttpEntity<>(json.toString(), httpHeaders);
        return restTemplate.postForObject(FIREBASE_API_URL, httpEntity, String.class);
    }
}
