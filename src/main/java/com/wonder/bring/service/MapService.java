package com.wonder.bring.service;

import com.wonder.bring.model.DefaultRes;

/**
 * Created by bomi on 2019-01-02.
 */

public interface MapService {
    DefaultRes getPoint(final double la, final double lo); // 위도, 경도 받아오기
    DefaultRes getStoreInfo(final int storeIdx);
}
