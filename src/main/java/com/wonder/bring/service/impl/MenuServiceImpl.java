package com.wonder.bring.service.impl;

import com.wonder.bring.dto.Menu;
import com.wonder.bring.dto.MenuDetail;
import com.wonder.bring.dto.SizePrice;
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

    /**
     * 메뉴 리스트 조회
     * @param storeIdx
     * @return 메뉴 리스트
     */
    @Override
    public DefaultRes<StoreMenu> findMenuByStoreIdx(int storeIdx) {
        // storeIdx로 메뉴 리스트 조회
        final StoreMenu storeMenu = menuMapper.findStoreByStoreIdx(storeIdx);
        List<Menu> menuList = menuMapper.findMenuByStoreIdx(storeIdx);

        // 해당 매장이 없을 때
        if(storeMenu == null) {
            return DefaultRes.res(Status.NOT_FOUND, Message.NOT_FOUND_STORE);
        } else if(menuList.isEmpty()) {
            return DefaultRes.res(Status.NOT_FOUND, Message.NOT_FOUND_LIST_MENU);
        } else {
            storeMenu.setMenuList(menuList);
        }
        return DefaultRes.res(Status.OK, Message.FIND_LIST_MENU, storeMenu);
    }

    /**
     * 메뉴 상세 정보 조회
     * @param storeIdx
     * @param menuIdx
     * @return 메뉴 상세 정보
     */
    @Override
    public DefaultRes<MenuDetail> findDetailMenu(int storeIdx, int menuIdx) {
        // 메뉴 상세 정보 조회
        final MenuDetail menuDetail = menuMapper.findMenuDetail(storeIdx, menuIdx);

        // 메뉴 정보가 없을 때
        if(menuDetail == null) {
            return DefaultRes.res(Status.NOT_FOUND, Message.NOT_FOUND_MENU_DETAIL);
        } else {
            List<SizePrice> sizePrices = menuMapper.findSizePriceByMenuIdx(menuIdx);
            // 사이즈 정보가 없을 때
            if(sizePrices.isEmpty()) {
                return DefaultRes.res(Status.NOT_FOUND, Message.NOT_FOUND_SIZE_PRICE);
            }
            menuDetail.setSizePrices(sizePrices);
        }
        return DefaultRes.res(Status.OK, Message.FIND_MENU_DETAIL, menuDetail);
    }
}
