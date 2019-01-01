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
    @Select("SELECT DISTINCT a.menu_idx, a.name, a.photo_url, a.price FROM MENU a inner join STORES_MENU b ON (a.menu_idx = b.menu_idx) WHERE store_idx = #{store_idx}")
    List<Menu> findMenuByStoreIdx(@Param("store_idx") final int storeIdx);

    @Select("SELECT store_idx, name, address FROM STORES WHERE store_idx = #{store_idx}")
    StoreMenu findStoreByStoreIdx(@Param("store_idx") final int storeIdx);

    @Select("SELECT photo_url FROM STORE_PHOTOS WHERE store_idx = #{store_idx} AND photo_idx = 1")
    String findStorePhotoByStoreIdx(@Param("store_idx") final int storeIdx);

/*    *//**
     * 메뉴 상세 정보 조회
     * @return 메뉴 상세 정보
     *//*
    @Select("SELECT a.menu_idx, b.store_idx, a.name, a.photo_url, a.price, price*#{count} AS totalPrice FROM MENU a inner join STORES_MENU b ON (a.menu_idx = b.menu_idx) WHERE size = #{size} AND b.store_idx = #{store_idx} AND a.name = (SELECT name FROM MENU WHERE menu_idx = #{menu_idx})")
    MenuDetail findDetailMenuBySizeAndCount(@Param("store_idx") final int storeIdx, @Param("menu_idx") final int menuIdx, @Param("size") final int size, @Param("count") final int count);*/
}
