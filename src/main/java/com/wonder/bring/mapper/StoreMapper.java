package com.wonder.bring.mapper;

import com.wonder.bring.dto.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StoreMapper {

    /**
     * 매장 정보 상세 조회
     * @return
     */
    @Select("SELECT store_idx, time, number FROM STORES WHERE store_idx = #{store_idx}")
    Store findByStoreIdx(@Param("store_idx") final int storeIdx);
}
