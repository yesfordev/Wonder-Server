package com.wonder.bring.service;

import com.wonder.bring.dto.Order;
import com.wonder.bring.dto.OrderInfo;
import com.wonder.bring.model.DefaultRes;
import javafx.scene.control.Pagination;

import java.util.List;

public interface OrderService {
    DefaultRes<Order> getOrderList(final int userIdx);
}
