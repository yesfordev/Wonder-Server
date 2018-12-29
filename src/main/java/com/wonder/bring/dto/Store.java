package com.wonder.bring.dto;

import lombok.Data;

import java.util.List;


@Data
public class Store {
    // 매장 이름
    private String name;
    // 매장 주소
    private String address;
    // 사진
    private List<String> photo;
    // 운영시간, 휴무일
    private String time;
    // 전화번호
    private String number;
}
