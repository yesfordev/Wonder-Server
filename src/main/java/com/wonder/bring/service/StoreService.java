package com.wonder.bring.service;

import com.wonder.bring.dto.Store;
import com.wonder.bring.model.DefaultRes;

import java.util.List;

public interface StoreService {
    DefaultRes<Store> findByStoreIdx(final int storeIdx); //매장 상세 정보 조회
}
