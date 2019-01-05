package com.wonder.bring.service.impl;

import com.wonder.bring.dto.Store;
import com.wonder.bring.mapper.StoreMapper;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.service.StoreService;
import com.wonder.bring.utils.Message;
import com.wonder.bring.utils.Status;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by YoungEun on 2018-12-29.
 */

@Service
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
        final Store store = storeMapper.findDetailByStoreIdx(storeIdx);

        if(store == null) {
            return DefaultRes.res(Status.NOT_FOUND, Message.NOT_FOUND_DETAIL_STORE);
        } else {
            List<String> storePhoto = storeMapper.findPhotoByStoreIdx(storeIdx);
            store.setPhotoUrl(storePhoto);
        }
        return DefaultRes.res(Status.OK, Message.READ_DETAIL_STORE, store);
    }
}
