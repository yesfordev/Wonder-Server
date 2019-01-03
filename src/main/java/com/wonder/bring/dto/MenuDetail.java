package com.wonder.bring.dto;

import lombok.Data;

import java.util.List;


@Data
public class MenuDetail {
    // menuIdx
    private int menuIdx;
    // 매장 고유 번호
    private int storeIdx;
    // 메뉴 이름
    private String name;
    // 메뉴 사진
    private String photoUrl;
    // 사이즈 별 가격
    private List<SizePrice> sizePrices;
}