package com.wonder.bring.service.impl;

import com.wonder.bring.dto.Menu;
import com.wonder.bring.dto.MenuDetail;
import com.wonder.bring.dto.StoreMenu;
import com.wonder.bring.mapper.MenuMapper;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.service.MenuService;
import com.wonder.bring.utils.Message;
import com.wonder.bring.utils.Status;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by YoungEun on 2018-12-29.
 */

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public DefaultRes<StoreMenu> findMenuByStoreIdx(int storeIdx) {
        // 메뉴 리스트 조회
        final StoreMenu storeMenu = menuMapper.findStoreByStoreIdx(storeIdx);

        if(storeMenu == null) {
            return DefaultRes.res(Status.NOT_FOUND, Message.NOT_FOUND_LIST_MENU);
        } else {
            List<Menu> menuList = menuMapper.findMenuByStoreIdx(storeIdx);
            storeMenu.setMenuList(menuList);
            storeMenu.setStorePhotoUrl(menuMapper.findStorePhotoByStoreIdx(storeIdx));
        }
        return DefaultRes.res(Status.OK, Message.FIND_LIST_MENU, storeMenu);
    }
/*
    @Override
    public DefaultRes<MenuDetail> findDetailMenu(int storeIdx, int menuIdx, int count, int size) {
        // 메뉴 상세 정보 조회
        final MenuDetail menuDetail = menuMapper.findDetailMenuBySizeAndCount(storeIdx, menuIdx, size, count);

        if(menuDetail == null) {
            return DefaultRes.res(Status.NOT_FOUND, Message.NOT_FOUND_MENU_DETAIL);
        }
        return DefaultRes.res(Status.OK, Message.FIND_MENU_DETAIL, menuDetail);
    }*/
}
