package com.wonder.bring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FcmMapper {
    //orderIdx로 fcm토큰 값 조회
    @Select("SELECT fcm_token from OWNER " +
            "INNER JOIN STORES ON (OWNER.owner_idx = STORES.owner_idx) " +
            "INNER JOIN ORDER_LISTS ON (ORDER_LISTS.store_idx = STORES.store_idx) " +
            "WHERE ORDER_LISTS.order_idx = #{orderIdx}")
    String getFcmToken(final int orderIdx);
}
