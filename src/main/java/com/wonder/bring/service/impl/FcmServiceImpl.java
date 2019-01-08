package com.wonder.bring.service.impl;

import com.wonder.bring.mapper.FcmMapper;
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
    private final FcmMapper fcmMapper;
    private final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
    private final String FIREBASE_SERVER_KEY = "YOUR_SERVER_KEY";

    public FcmServiceImpl(final FcmMapper fcmMapper) {
        this.fcmMapper = fcmMapper;
    }

    @Override
    public void sendPush(final int orderIdx) {
        JSONObject msg = new JSONObject();

        //주문번호로 푸쉬보낼 점주의 토큰값 찾아오기
        String fcmToken = fcmMapper.getFcmToken(orderIdx);

        //타이틀과 내용을 db에서 갖고와서 넣을것
        //msg.put("title", messageTitle);
        //msg.put("body", message);

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
