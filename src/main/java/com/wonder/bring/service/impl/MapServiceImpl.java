package com.wonder.bring.service.impl;

import com.wonder.bring.dto.Point;
import com.wonder.bring.dto.Store;
import com.wonder.bring.mapper.MapMapper;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.service.MapService;
import com.wonder.bring.utils.Message;
import com.wonder.bring.utils.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bomi on 2019-01-02.
 */

@Slf4j
@Service
public class MapServiceImpl implements MapService {

    private final MapMapper mapMapper;

    public MapServiceImpl(final MapMapper mapMapper) {
        this.mapMapper = mapMapper;
    }

    /**
     * 주위의 매장 위도 경도 좌표 조회
     * @param la
     *      지금 현재 나의 위도
     * @param lo
     *      지금 현재 나의 경도
     * @return 1km 이내의 매장 위치 좌표
     */
   @Override
    public DefaultRes getPoint(final double la, final double lo) {
        List<Point> list = mapMapper.getStorePoints(lo, la);
        return DefaultRes.res(Status.OK, Message.FIND_POINT_SUCCESS, list);
    }

    /**
     * 선택한 매장의 정보 조회
     * @param storeIdx
     *      선택한 매장의 고유 idx
     * @return 결과 데이터
     */
    @Override
    public DefaultRes getStoreInfo(final int storeIdx) {
        Store store = mapMapper.getStoreInfo(storeIdx);

        if(store == null) {
            return DefaultRes.res(Status.NOT_FOUND, Message.FIND_STORE_FAIL);
        } else {
            List<String> photoUrl = mapMapper.getStorePhoto(storeIdx);
            store.setPhoto(photoUrl);
            return DefaultRes.res(Status.OK, Message.FIND_STORE_SUCCESS, store);
        }
    }
}
