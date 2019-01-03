package com.wonder.bring.mapper;

import com.wonder.bring.dto.OrderDetailInfo;
import com.wonder.bring.dto.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    //userIdx로 전체주문내역 받아오는 쿼리
    @Select("SELECT ORDER_LISTS.order_idx, ORDER_LISTS.time, ORDER_LISTS.state, STORES.name " +
            "FROM ORDER_LISTS JOIN STORES ON STORES.store_idx = ORDER_LISTS.store_idx " +
            "WHERE user_idx = #{userIdx} AND state != 3 ORDER BY time DESC")
    List<OrderInfo> findOrderAll(@Param("userIdx") final int userIdx);

    @Select("SELECT nick FROM USERS WHERE user_idx = #{userIdx}")
    String findOrderNick(@Param("userIdx") final int userIdx);

    /**
     * 주문 내역 상세 조회
     * @return
     */
    //매장이름
    @Select("SELECT s.name FROM STORES s inner join ORDER_LISTS o ON (s.store_idx = o.store_idx) WHERE o.order_idx = #{order_idx}")
    String findStoreByOrderIdx(@Param("order_idx") final int orderIdx);

    //메뉴이름 사이즈 수량 총가격 요청사항
    @Select("SELECT m.name, o.size, o.order_count, o.total_price, o.memo " +
            "FROM MENU m " +
            "inner join ORDER_MENU o ON (m.menu_idx = o.menu_idx) " +
            "WHERE o.order_idx = #{order_idx}")
    List<OrderDetailInfo> findOrderByOrderIdx(@Param("order_idx") final int orderIdx);
}
