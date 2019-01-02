package com.wonder.bring.service.impl;

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

   @Override
    public DefaultRes getPoint(final double la, final double lo) {

        return DefaultRes.res(Status.OK, Message.FIND_POINT_SUCCESS, mapMapper.getPoint(la, lo));
    }

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
