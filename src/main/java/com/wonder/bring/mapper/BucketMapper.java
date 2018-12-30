package com.wonder.bring.mapper;

import com.amazonaws.services.s3.model.Bucket;
import com.wonder.bring.model.BucketReq;
import org.apache.ibatis.annotations.*;


@Mapper
public interface BucketMapper {

    //장바구니 추가
    @Insert("INSERT INTO BUCKETS(store_idx,menu_idx,user_idx,count,memo) " +
            "VALUES(#{BucketReq.storeIdx},#{BucketReq.menuIdx},#{BucketReq.userIdx},#{BucketReq.count},#{BucketReq.memo})")
    void addBucket(@Param("BucketReq") final BucketReq bucketReq);

    /*
    //장바구니 리스트 조회
    @Select("SELECT * FROM buckets WHERE user_idx = #{id}")
    Bucket findByUserIdx(@Param("userIdx") final int userIdx);

    //장바구니 수량 수정
    @Update("UPDATE buckets SET count = #{bucket.count} WHERE bucketIdx = #{bucketIdx}")
    void update(@Param("bucketIdx") final int bucketIdx);

    //장바구니 메뉴 삭제
    @Delete("DELETE FROM buckets where bucket_idx = #{bucketIdx}")
    void deleteByBucketIdx(@Param("bucketIdx") final int bucketIdx);
    */
}
