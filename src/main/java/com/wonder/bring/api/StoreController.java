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

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.wonder.bring.model.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/stores/{storeIdx}")
    public ResponseEntity getStore(final HttpServletRequest httpServletRequest,
                                   @PathVariable(value = "storeIdx") final int storeIdx) {
        try {
            DefaultRes<Store> defaultRes = storeService.findByStoreIdx(storeIdx);

            if(defaultRes.getStatus() == 200) {
                defaultRes.getData();
            }
            return new ResponseEntity<>(defaultRes, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
