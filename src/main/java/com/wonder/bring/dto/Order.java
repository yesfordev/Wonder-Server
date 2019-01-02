package com.wonder.bring.dto;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String nick;
    private List<OrderInfo> orderList;

    public Order(final String nick, final List<OrderInfo> orderList) {
        this.nick = nick;
        this.orderList = orderList;
    }
}
