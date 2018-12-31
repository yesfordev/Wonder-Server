package com.wonder.bring.service;

import com.wonder.bring.model.BucketReq;
import com.wonder.bring.model.DefaultRes;

public interface BucketService {
    DefaultRes addBucket(final BucketReq bucketReq);
    //Object deleteByBucketIdx(int bucketIdx);
}
