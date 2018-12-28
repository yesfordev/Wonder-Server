package com.wonder.bring.dto;

import lombok.Data;



@Data
public class Store {
    // 매장 고유 번호
    private int storeIdx;
    // 매장 이름
    private String name;
    // 매장 주소
    private String address;
    // 프렌차이즈인지
    private String type;
    // 위도
    private double latitude;
    // 경도
    private double longitude;
    // 전화번호
    private String number;
    // 운영시간, 휴무일
    private String time;
    // 홈페이지 주소
    private String homepage;
}
