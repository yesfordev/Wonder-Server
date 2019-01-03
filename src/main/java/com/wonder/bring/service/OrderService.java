package com.wonder.bring.service;

import com.wonder.bring.dto.Order;
import com.wonder.bring.dto.OrderDetail;
import com.wonder.bring.dto.OrderInfo;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.model.OrderReq;
import javafx.scene.control.Pagination;

import java.util.List;

public interface OrderService {
    //주문하기 저장
    DefaultRes createOrder(final int userIdx, final OrderReq orderReq);

    //전체주문내역
    DefaultRes<Order> getOrderList(final int userIdx);

    //주문내역 상세 조회
    DefaultRes<OrderDetail> getOrderDetailList(final int orderIdx);
}
