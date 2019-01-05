package com.wonder.bring.dto;

import lombok.Data;

import java.util.List;

@Data
public class StoreMenu {
    // 매장 고유 번호
    private int storeIdx;
    // 매장 이름
    private String name;
    // 매장 주소
    private String address;
    // 매장 대표 사진(photo_idx = 1)
    private String bgPhotoUrl;
    // 메뉴
    private List<Menu> menuList;
}
