package com.wonder.bring.service.impl;

import com.wonder.bring.dto.Store;
import com.wonder.bring.mapper.StoreMapper;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.service.StoreService;

public class StoreServiceImpl implements StoreService {

    private final StoreMapper storeMapper;

    public StoreServiceImpl(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    /**
     * 매장 상세 정보 조회
     * @param storeIdx 매장 고유 번호
     * @return
     */
    @Override
    public DefaultRes<Store> findByStoreIdx(int storeIdx) {
        // 매장 상세 정보 조회
        final Store store = storeMapper.findByStoreIdx(storeIdx);
        if(store == null) return DefaultRes.res(Status.NOT_FOUND)
        return null;
    }


}
