package com.wonder.bring.service.impl;

import com.wonder.bring.dto.Order;
import com.wonder.bring.mapper.OrderMapper;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.service.OrderService;
import com.wonder.bring.utils.Status;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;

    public OrderServiceImpl(final OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    private static List<Order> orderList = new LinkedList<>();
    //카페별 주문목록 조회
    @Override
    public DefaultRes<List<Order>> getOrderList(final int userIdx) {
        orderList = orderMapper.findOrderAll(userIdx);
        if(orderList.isEmpty())
            return DefaultRes.res(Status.NOT_FOUND, "주문내역이 없습니다");
        return DefaultRes.res(Status.OK, "리스트 조회 성공");
    }

}
