package com.wonder.bring.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MenuReq {

    private int menuIdx;
    private String name;
    private MultipartFile photo;
    private int price;
    private String size;

    public boolean checkproperties() {
        return (name != null && size != null && photo != null);
    }
}
