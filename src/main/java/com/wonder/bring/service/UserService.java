package com.wonder.bring.service;

import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.model.SignUpReq;

/**
 * Created by bomi on 2018-12-28.
 */

public interface UserService {
    DefaultRes saveUser(final SignUpReq signUpReq);
    DefaultRes dupleCheckId(final String id);
    DefaultRes dupleCheckNick(final String nick);
    DefaultRes getUser(final int userIdx);
}
