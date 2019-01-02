package com.wonder.bring.dto;

import lombok.Data;

@Data
public class MenuDetail {
    // 매장 고유 번호
    private int storeIdx;
    // 메뉴 이름
    private String name;
    // 메뉴 사진
    private String photoUrl;
    // size가 small일 때 menuIdx
    private int menuIdx;
    // size가 small일 때 가격
    private int price;
    // size가 Jumbo일 때
    private JumboMenu jumboMenu;
}
