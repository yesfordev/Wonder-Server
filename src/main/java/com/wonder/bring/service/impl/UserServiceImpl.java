package com.wonder.bring.service.impl;

import com.wonder.bring.mapper.UserMapper;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.model.SignUpReq;
import com.wonder.bring.service.S3FileUploadService;
import com.wonder.bring.service.UserService;
import com.wonder.bring.utils.Message;
import com.wonder.bring.utils.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by bomi on 2018-12-28.
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    // UserService에서 파일 업로드(사진 업로드)를 위해 추가
    private final S3FileUploadService s3FileUploadService;

    /**
     * 생성자 의존성 주입
     * @param userMapper
     * @param s3FileUploadService
     */
    public UserServiceImpl(final UserMapper userMapper, final S3FileUploadService s3FileUploadService) {
        this.s3FileUploadService = s3FileUploadService;
        this.userMapper = userMapper;
    }

    /**
     * 회원 가입
     * @param signUpReq
     *      가입할 회원 데이터
     * @return 결과 데이터
     */
    @Transactional
    @Override
    public DefaultRes saveUser(final SignUpReq signUpReq) {
        try {
            // 가입 전 id, nick 중복 검사
            if(dupleCheckId(signUpReq.getId()).getStatus() != 200
            || dupleCheckNick(signUpReq.getNick()).getStatus() != 200) {
                return DefaultRes.res(Status.BAD_REQUEST, Message.SIGN_UP_FAIL);
            }

            // 빈칸 검사
            if(signUpReq.getId().isEmpty() || signUpReq.getPasswd().isEmpty() || signUpReq.getNick().isEmpty()) {
                return DefaultRes.NO_CONTENT_DEFAULT_RES;
            }

            // 중복되지 않았다면 저장
            userMapper.save(signUpReq);
            int idx = userMapper.findByUserId(signUpReq.getId());
            // 프로필 사진이 있을 경우
            if(signUpReq.getProfile() != null) {
                String url = s3FileUploadService.upload(signUpReq.getProfile());
                userMapper.savePhoto(url, idx);
            }
            return DefaultRes.res(Status.CREATED, Message.SIGN_UP_SUCCESS);
        } catch(Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(Status.DB_ERROR, Message.DB_ERROR);
        }
    }

    /**
     * id 중복 검사
     * @param id
     *      중복 검사할 id
     * @return 결과 데이터
     */
    @Override
    public DefaultRes dupleCheckId(final String id) {
        int check = userMapper.checkId(id);
        // 이미 존재하는 id일 경우
        if(check > 0) {
            return DefaultRes.res(Status.BAD_REQUEST, Message.CHECK_FAIL);
        }
        return DefaultRes.res(Status.OK, Message.CHECK_SUCCESS);
    }

    /**
     * 닉네임 중복 검사
     * @param nick
     *      중복 검사할 닉네임
     * @return 결과 데이터
     */
    @Override
    public DefaultRes dupleCheckNick(final String nick) {
        int check = userMapper.checkNick(nick);
        // 이미 존재하는 nick일 경우
        if(check > 0) {
            return DefaultRes.res(Status.BAD_REQUEST, Message.CHECK_FAIL);
        }
        return DefaultRes.res(Status.OK, Message.CHECK_SUCCESS);
    }
}
