package com.wonder.bring.api;

import com.wonder.bring.dto.Store;
import com.wonder.bring.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wonder.bring.model.DefaultRes.FAIL_DEFAULT_RES;

/**
 * Created by bomi on 2019-01-02.
 */

@Slf4j
@RequestMapping("maps")
@RestController
public class MapController {
    private final MapService mapService;

    public MapController(final MapService mapService) {
        this.mapService = mapService;
    }

    /**
     * 1km이내의 매장 조회
     * @param latitude
     *      위도
     * @param longitude
     *      경도
     * @return
     */
    @GetMapping("")
    public ResponseEntity getPoint(@RequestParam(value = "latitude", required = true) final double latitude,
                                   @RequestParam(value = "longitude", required = true) final double longitude) {
        try {
            return new ResponseEntity(mapService.getPoint(latitude, longitude), HttpStatus.OK);
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 선택한 카페 정보 보여주기
     * @param storeIdx
     *      선택한 매장 고유 idx
     * @return
     */
    @GetMapping("stores/{storeIdx}")
    public ResponseEntity getStoreInfo(@PathVariable(value = "storeIdx") final int storeIdx) {
        try {
            return new ResponseEntity(mapService.getStoreInfo(storeIdx), HttpStatus.OK);
        } catch(Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
