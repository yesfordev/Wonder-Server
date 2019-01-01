package com.wonder.bring.service;

import com.wonder.bring.dto.Order;
import com.wonder.bring.model.DefaultRes;

import java.util.List;

public interface OrderService {
    DefaultRes<List<Order>> getOrderList(final int userIdx);
}
