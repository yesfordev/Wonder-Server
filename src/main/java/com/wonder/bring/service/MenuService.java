package com.wonder.bring.service;

import com.wonder.bring.dto.Menu;
import com.wonder.bring.model.DefaultRes;

public interface MenuService {
    // 메뉴 리스트 조회
    DefaultRes<Menu> findMenuByStoreIdx(final int storeIdx);
    // 메뉴 상세 정보 조회
    DefaultRes<Menu> findDetailMenu(final int storeIdx, final int menuIdx);

}
