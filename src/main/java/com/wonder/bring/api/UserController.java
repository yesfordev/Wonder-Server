package com.wonder.bring.api;

import com.wonder.bring.dto.User;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.model.SignUpReq;
import com.wonder.bring.service.JwtService;
import com.wonder.bring.service.UserService;
import com.wonder.bring.utils.Message;
import com.wonder.bring.utils.Status;
import com.wonder.bring.utils.auth.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static com.wonder.bring.model.DefaultRes.*;

/**
 * Created by bomi on 2018-12-28.
 */

@Slf4j
@RequestMapping("users")
@RestController
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    private static final DefaultRes FORBIDDEN_RES = new DefaultRes(Status.FORBIDDEN, Message.FORBIDDEN);
    private static final DefaultRes NO_CONTENT_RES = new DefaultRes(Status.BAD_REQUEST, Message.NO_CONTENT);

    // 생성자 의존성 주입
    public UserController(final UserService userService, final JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    /**
     * 마이페이지 조회
     * @param userIdx
     *      조회할 회원의 고유 idx
     * @return 조회 결과
     */
    @Auth
    @GetMapping("{userIdx}")
    public ResponseEntity getMyPage(@RequestHeader(value = "Authorization") final String header,
                                    @PathVariable(value = "userIdx") final int userIdx) {
        try {
            // 권한 검사
            if(jwtService.checkAuth(header, userIdx)) {
                DefaultRes<User> defaultRes = userService.getUser(userIdx);
                defaultRes.getData().setAuth(true);
                return new ResponseEntity(defaultRes, HttpStatus.OK);
            } else {
                return new ResponseEntity(FORBIDDEN_RES, HttpStatus.OK);
            }
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 회원 가입
     * @param signUpReq
     *      가입할 객체
     * @return 결과 데이터
     */
    @PostMapping("")
    public ResponseEntity signUp(SignUpReq signUpReq, @RequestPart(value = "profile", required = false) final MultipartFile profile) {
        try {
            if(profile != null) {
                signUpReq.setProfile(profile);
            }
            return new ResponseEntity(userService.saveUser(signUpReq), HttpStatus.OK);
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * id, nickname 중복 체크
     * @param id
     *      중복체크할 id
     * @param nick
     *      중복체크할 nick
     * @return 결과 데이터
     */
    @GetMapping("check")
    public ResponseEntity dupleCheck(@RequestParam("id") final Optional<String> id,
                                     @RequestParam("nick") final Optional<String> nick) {
        try {
            if(id.isPresent()) {
                // id 중복검사
                return new ResponseEntity(userService.dupleCheckId(id.get()), HttpStatus.OK);
            } else if(nick.isPresent()) {
                // 닉네임 중복검사
                return new ResponseEntity(userService.dupleCheckNick(nick.get()), HttpStatus.OK);
            } else {
                // 값이 없을 경우
                return new ResponseEntity(NO_CONTENT_RES, HttpStatus.OK);
            }
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}