package com.wonder.bring.service;
import com.wonder.bring.service.impl.JwtServiceImpl;

public interface JwtService {
    String create(final int userIdx);
    JwtServiceImpl.Token decode(final String token);
}
