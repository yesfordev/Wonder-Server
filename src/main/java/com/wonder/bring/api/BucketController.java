package com.wonder.bring.api;

import com.wonder.bring.dto.Bucket;
import com.wonder.bring.model.BucketReq;
import com.wonder.bring.service.BucketService;
import com.wonder.bring.service.impl.AuthServiceImpl;
import com.wonder.bring.service.impl.BucketServiceImpl;
import com.wonder.bring.utils.auth.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wonder.bring.model.DefaultRes.FAIL_DEFAULT_RES;


@Slf4j
@RestController
@RequestMapping("buckets")
public class BucketController {

    //장바구니 토큰 필요
    private final AuthServiceImpl authServiceImpl;
    private final BucketServiceImpl bucketServiceImpl;

    public BucketController(final AuthServiceImpl authServiceImpl, final BucketServiceImpl bucketServiceImpl) {
        this.authServiceImpl = authServiceImpl;
        this.bucketServiceImpl = bucketServiceImpl;
    }


    @Auth
    @PostMapping("")
    public ResponseEntity add(@RequestBody final BucketReq bucketReq) {
        try {
            return new ResponseEntity<>(bucketServiceImpl.addBucket(bucketReq), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    //장바구니 수량 수정
    @Auth
    @PutMapping("/{bucketIdx}")
    public ResponseEntity signUp(
            @PathVariable(value = "bucketIdx") final int bucketIdx,
            BucketReq bucketReq,
            @RequestPart(value = "profile", required = false) final MultipartFile profile) {
        try {
            if (profile != null) signUpReq.setProfile(profile);
            return new ResponseEntity<>(userService.update(userIdx, signUpReq), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Auth
    @DeleteMapping("/{bucketIdx}")
    public ResponseEntity deleteBucket(@PathVariable(value = "bucketIdx") final int bucketIdx) {
        try {
            return new ResponseEntity<>(bucketService.deleteByBucketIdx(bucketIdx), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        */
}
