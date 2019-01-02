package com.wonder.bring.dto;

import lombok.Data;

@Data
public class Order {
    //private String nick;
    private int orderIdx;
    //private int storeIdx;
    private String name; //매장이름
    private int state;
    private String time;
}
