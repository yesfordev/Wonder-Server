package com.wonder.bring.mapper;

import com.wonder.bring.dto.Order;
import com.wonder.bring.dto.OrderInfo;
import com.wonder.bring.model.OrderMenu;
import com.wonder.bring.model.OrderReq;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.*;

import java.util.Date;
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

    ///orderlist 생성
    @Insert("INSERT INTO ORDER_LISTS(store_idx, user_idx, time) VALUES(#{orderReq.storeIdx}, #{userIdx}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty="orderReq.orderIdx")
    int createOrderLIst(@Param("orderReq") final OrderReq orderReq, @Param("userIdx") final int userIdx,
                        @Param("time") final Date now);

    @Insert("INSERT INTO ORDER_MENU VALUES(#{orderMenu.menuIdx}, #{orderIdx}, #{orderMenu.orderCount}, " +
            "(SELECT price FROM SIZE_PRICE WHERE SIZE_PRICE.menu_idx = #{orderMenu.menuIdx} " +
            "AND SIZE_PRICE.size = #{orderMenu.size})*#{orderMenu.orderCount}, #{orderMenu.memo}, #{orderMenu.size})")
    void createOrderMenu(@Param("orderIdx") final int orderIdx, @Param("orderMenu") final OrderMenu orderMenu);
}
