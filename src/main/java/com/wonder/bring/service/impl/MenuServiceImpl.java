package com.wonder.bring.service.impl;

import com.wonder.bring.dto.Menu;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {


    @Override
    public DefaultRes<Menu> findMenuByStoreIdx(int storeIdx) {

        return null;
    }

    @Override
    public DefaultRes<Menu> findDetailMenu(int storeIdx, int menuIdx) {
        return null;
    }
}
