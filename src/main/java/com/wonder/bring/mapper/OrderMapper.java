package com.wonder.bring.mapper;

import com.wonder.bring.dto.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    //userIdx로 전체주문내역 받아오는 쿼리
    //아직 제대로 안짬~~~
    @Select("SELECT * FROM STORES")
    List<Order> findOrderAll(@Param("userIdx") final int userIdx);

}
