package com.wonder.bring.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class StoreReq {

    private int storeIdx;
    private String name;
    private String address;
    private String type;
    private double latitude;
    private double longitude;
    private String number;
    private String time;
    private String homepage;
    private MultipartFile[] photo;

    public boolean checkproperties() {
        return (name != null && photo != null);
    }
}
