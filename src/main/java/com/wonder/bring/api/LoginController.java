package com.wonder.bring.api;

import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.model.LoginReq;
import com.wonder.bring.service.AuthService;
import com.wonder.bring.utils.Message;
import com.wonder.bring.utils.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    private static final DefaultRes FAIL_DEFAULT_RES = new DefaultRes(Status.INTERNAL_SERVER_ERROR, Message.INTERNAL_SERVER_ERROR);

    private final AuthService authServiceImpl;

    public LoginController(final AuthService authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody final LoginReq loginReq) {
        try {
            return new ResponseEntity<>(authServiceImpl.login(loginReq), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
