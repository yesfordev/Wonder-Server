package com.wonder.bring.service.impl;

import com.wonder.bring.mapper.BucketMapper;
import com.wonder.bring.model.BucketReq;
import com.wonder.bring.model.DefaultRes;
import com.wonder.bring.service.BucketService;
import com.wonder.bring.utils.Message;
import com.wonder.bring.utils.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class BucketServiceImpl implements BucketService {

    private final BucketMapper bucketMapper;

    public BucketServiceImpl(final BucketMapper bucketMapper) {
        this.bucketMapper = bucketMapper;
    }

    @Override
    public DefaultRes addBucket(final BucketReq bucketReq) {
        try {
            bucketMapper.addBucket(bucketReq);
            return DefaultRes.res(Status.CREATED, Message.BUCKET_ADD_SUCCESS);
        }catch(Exception e) {
            return DefaultRes.res(Status.DB_ERROR, Message.DB_ERROR);
        }


    }

}
