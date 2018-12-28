package com.wonder.bring.api;

import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.service.UserService;
import com.wonder.bring.utils.Message;
import com.wonder.bring.utils.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bomi on 2018-12-28.
 */

@Slf4j
@RequestMapping("users")
@RestController
public class UserController {
    private static final DefaultRes FAIL_DEFAULT_RES = new DefaultRes(Status.INTERNAL_SERVER_ERROR, Message.INTERNAL_SERVER_ERROR);

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

}
