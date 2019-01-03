package com.wonder.bring.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDetail {
    private String store;
    private List<OrderDetailInfo> orderDetailList;

    public OrderDetail(final String store, final List<OrderDetailInfo> orderDetailList) {
        this.store = store;
        this.orderDetailList = orderDetailList;
    }
}