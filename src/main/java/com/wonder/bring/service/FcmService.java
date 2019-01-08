package com.wonder.bring.service;

public interface FcmService {
    void sendPush(final String fcmToken, final String title, final String message);
}
