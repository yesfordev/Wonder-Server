package com.wonder.bring.dto;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String nick;
    private List<OrderInfo> orderList;
}
