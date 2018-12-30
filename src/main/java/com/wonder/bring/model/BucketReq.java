package com.wonder.bring.model;

import lombok.Data;

@Data
public class BucketReq {
    private int userIdx;
    private int storeIdx;
    private int menuIdx;
    private int count;
    private String memo;
}
