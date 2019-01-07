package com.wonder.bring.service;

import com.wonder.bring.dto.Store;
import com.wonder.bring.model.DefaultRes;

/**
 * Create by YoungEun on 2018-12-29.
 */

public interface StoreService {
    DefaultRes<Store> findByStoreIdx(final int storeIdx); //매장 상세 정보 조회
}
