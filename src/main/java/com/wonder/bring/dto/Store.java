package com.wonder.bring.dto;

import lombok.Data;


@Data
public class Store {
    // 매장 이름
    private String name;
    // 매장 주소
    private String address;
    // 운영시간, 휴무일
    private String time;
    // 전화번호
    private String number;
    // 사진
    private String bgPhotoUrl;
}
