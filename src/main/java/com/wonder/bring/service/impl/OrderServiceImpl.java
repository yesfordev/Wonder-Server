package com.wonder.bring.service.impl;

import com.wonder.bring.dto.Order;
import com.wonder.bring.dto.OrderDetail;
import com.wonder.bring.dto.OrderDetailInfo;
import com.wonder.bring.dto.OrderInfo;
import com.wonder.bring.mapper.OrderMapper;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.model.OrderMenu;
import com.wonder.bring.model.OrderReq;
import com.wonder.bring.service.OrderService;
import com.wonder.bring.utils.Message;
import com.wonder.bring.utils.Status;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class  OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;

    public OrderServiceImpl(final OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    private static List<OrderInfo> orderList = new LinkedList<>();
    private static List<OrderDetailInfo> orderDetailList = new LinkedList<>();

    /**
     * 주문하기 생성
     */
    @Transactional
    @Override
    public DefaultRes createOrder(final int userIdx, final OrderReq orderReq) {
        if (!orderReq.checkEmpty()) {
            try {
                orderMapper.createOrderLIst(orderReq, userIdx);

                int orderIdx = orderReq.getOrderIdx();

                for (OrderMenu orderMenu : orderReq.getOrderMenuList()) {
                    orderMapper.createOrderMenu(orderIdx, orderMenu);
                }
                return DefaultRes.res(Status.CREATED, Message.CREATE_ORDER_SUCCESS);
            } catch (Exception e) {
                log.info(e.getMessage());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

                return DefaultRes.res(Status.DB_ERROR, Message.DB_ERROR);
            }
        }
        return DefaultRes.res(Status.BAD_REQUEST, Message.FAIL_CREATE_ORDER);
    }

    /**
     * 주문내역 전체조회
     */
    @Override
    public DefaultRes<Order> getOrderList(final int userIdx) {

        String nick = orderMapper.findOrderNick(userIdx);
        orderList = orderMapper.findOrderAll(userIdx);
        final Order order = new Order(nick, orderList);
        if(orderList.isEmpty())
            return DefaultRes.res(Status.NO_CONTENT, "주문내역이 존재하지 않습니다");

        return DefaultRes.res(Status.OK, "주문내역 조회 성공", order);
    }

    /**
     * 주문내역 상세조회
     */
    @Override
    public DefaultRes<OrderDetail> getOrderDetailList(final int orderIdx) {
        String store = orderMapper.findStoreByOrderIdx(orderIdx);

        orderDetailList = orderMapper.findOrderByOrderIdx(orderIdx);

        final OrderDetail orderDetail = new OrderDetail(store, orderDetailList);

        return DefaultRes.res(Status.OK, "주문 상세내역 조회 성공", orderDetail);
    }

}
