package com.wonder.bring.mapper;

import com.wonder.bring.dto.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreMapper {

    /**
     * 매장 정보 상세 조회
     * @return
     */
    @Select("SELECT name, address, type, number, time FROM STORES WHERE store_idx = #{store_idx}")
    Store findDetailByStoreIdx(@Param("store_idx") final int storeIdx);

    @Select("SELECT b.photo_url FROM STORES a inner join STORE_PHOTOS b on (a.store_idx = b.store_idx) WHERE a.store_idx = #{store_idx}")
    List<String> findPhotoByStoreIdx(@Param("store_idx") final int storeIdx);
}
