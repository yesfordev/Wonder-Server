package com.wonder.bring.service;

import java.util.List;

public interface FcmService {
    void sendPush(final String fcmToken, final String title, final String message);
}
