package com.wonder.bring.api;

import com.wonder.bring.dto.Store;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.wonder.bring.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Create by YoungEun on 2018-12-29.
 */

@Slf4j
@RestController
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // 매장 상세 정보 조회
    @GetMapping("/stores/{storeIdx}")
    public ResponseEntity getStore(@PathVariable(value = "storeIdx") final int storeIdx) {
        try {
            DefaultRes<Store> defaultRes = storeService.findByStoreIdx(storeIdx);

            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
