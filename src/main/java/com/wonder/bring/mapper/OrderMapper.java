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
    @Select("SELECT ")
    Order findOrderAll(@Param("userIdx") final int userIdx);


}
