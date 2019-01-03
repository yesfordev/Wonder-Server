package com.wonder.bring.mapper;

import com.wonder.bring.dto.Menu;
import com.wonder.bring.dto.MenuDetail;
import com.wonder.bring.dto.StoreMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Create by YoungEun on 2018-12-29.
 */

@Mapper
public interface MenuMapper {

    /**
     * 모든 메뉴 리스트 조회
     * @return 메뉴 리스트
     */
    // storeIdx로 menuList 조회(size = 0(small)일 때)
    @Select("SELECT a.menu_idx, a.name, a.photo_url, a.price FROM MENU a inner join STORES_MENU b ON (a.menu_idx = b.menu_idx) WHERE store_idx = #{store_idx} AND size = 0")
    List<Menu> findMenuByStoreIdx(@Param("store_idx") final int storeIdx);

    // storeIdx로 매장 정보 조회
    @Select("SELECT store_idx, name, address FROM STORES WHERE store_idx = #{store_idx}")
    StoreMenu findStoreByStoreIdx(@Param("store_idx") final int storeIdx);

    // storeIdx로 해당 매장에 menuList 존재 체크
    @Select("SELECT count(*) FROM STORES_MENU WHERE store_idx = #{store_idx}")
    int existMenuListByStoreIdx(@Param("store_idx") final int storeIdx);

    // storeIdx로 매장 대표 이미지 조회
    @Select("SELECT photo_url FROM STORE_PHOTOS WHERE store_idx = #{store_idx} AND photo_idx = 1")
    String findStorePhotoByStoreIdx(@Param("store_idx") final int storeIdx);

    /**
     * 메뉴 상세 정보 조회
     * @return 메뉴 상세 정보
     */
    // menuIdx로 size가 small일 때 조회
    @Select("SELECT b.store_idx, a.menu_idx, a.name, a.photo_url, a.price FROM MENU a INNER JOIN STORES_MENU b ON (a.menu_idx = b.menu_idx) WHERE b.store_idx = #{store_idx} AND a.menu_idx = #{menu_idx}")
    MenuDetail findMenuDetail(@Param("store_idx") final int storeIdx, @Param("menu_idx") final int menuIdx);

//    // size가 Jumbo일 때 조회
//    @Select("SELECT menu_idx, price FROM MENU WHERE name = (SELECT name FROM MENU WHERE menu_idx = #{menu_idx}) AND size = 1")
//    JumboMenu findJumboMenuByMenuIdx(@Param("menu_idx") final int menuIdx);
}
