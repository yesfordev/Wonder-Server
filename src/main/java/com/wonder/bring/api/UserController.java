package com.wonder.bring.api;

import com.wonder.bring.model.SignUpReq;
import com.wonder.bring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.wonder.bring.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Created by bomi on 2018-12-28.
 */

@Slf4j
@RequestMapping("users")
@RestController
public class UserController {
    private final UserService userService;

    // 생성자 의존성 주입
    public UserController(final UserService userService) {
        this.userService = userService;
    }


    /**
     * 마이페이지 조회
     * @param userIdx
     *      조회할 회원의 고유 idx
     * @return 조회 결과
     */
    @GetMapping("{userIdx}")
    public ResponseEntity getMyPage(@PathVariable(value = "userIdx") final int userIdx) {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 회원 가입
     * @param signUpReq
     *      가입할 객체
     * @return 결과 데이터
     */
    @PostMapping("")
    public ResponseEntity signUp(final SignUpReq signUpReq) {
        try {
            return new ResponseEntity(userService.saveUser(signUpReq), HttpStatus.OK);
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // 메소드 확인
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
                return new ResponseEntity(userService.dupleCheckId(id.get()), HttpStatus.OK);
            } return new ResponseEntity(userService.dupleCheckNick(nick.get()), HttpStatus.OK);
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}