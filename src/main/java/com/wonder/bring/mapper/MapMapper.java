package com.wonder.bring.mapper;

import com.wonder.bring.dto.Point;
import com.wonder.bring.dto.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by bomi on 2019-01-02.
 */

@Mapper
public interface MapMapper {
    @Select("SELECT latitude, longitude FROM STORES WHERE (latitude BETWEEN (#{latitude} - 0.01) AND (#{latitude} + 0.01)) AND (longitude BETWEEN (#{longitude} + 0.01) AND (#{longitude} + 0.01))")
    List<Point> getPoint(@Param("latitude") final double latitude, @Param("longitude") final double longitude);

    //@Select("SELECT name, address, type, number FROM STORE WHERE latitude = #{latitude} AND longitude = #{longitude}")
    //Store getStoreInfo(@Param("latitude") final double latitude, @Param("longitude") final double longitude);

    @Select("SELECT STORES.name, STORES.address, STORES.type, STORES.number FROM STORES WHERE store_idx = #{storeIdx}")
    Store getStoreInfo(@Param("storeIdx") final int storeIdx);

    @Select("SELECT STORE_PHOTOS.photo_url FROM STORES JOIN STORE_PHOTOS ON STORES.store_idx = STORE_PHOTOS.store_idx WHERE STORES.store_idx = #{storeIdx}")
    List<String> getStorePhoto(@Param("storeIdx") final int storeIdx);


}
