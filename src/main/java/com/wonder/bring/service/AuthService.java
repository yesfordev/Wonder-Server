package com.wonder.bring.service;

import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.model.LoginReq;
import com.wonder.bring.service.impl.JwtServiceImpl;

public interface AuthService {
     DefaultRes<JwtServiceImpl.TokenRes> login(final LoginReq loginReq);
}

