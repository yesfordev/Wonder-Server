package com.wonder.bring.dto;

import lombok.Data;

@Data
public class JumboMenu {
    // size가 Jumbo일 때 menuIdx
    private int menuIdx;
    // size가 Jumbo일 때 가격
    private int price;
}
