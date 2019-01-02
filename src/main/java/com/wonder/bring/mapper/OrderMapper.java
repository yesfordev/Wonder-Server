package com.wonder.bring.mapper;

import com.wonder.bring.dto.Order;
import com.wonder.bring.dto.OrderInfo;
import javafx.scene.control.Pagination;
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


}
