package com.bucket.controller;

import com.bucket.entity.Bucket;
import com.bucket.entity.Member;
import com.bucket.service.BucketService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/bucket")
public class BucketController {

    @Autowired
    private BucketService BucketSer;

    @GetMapping(value="/list")
    public List<Bucket> bucket_list(){
        List<Bucket> list = BucketSer.getBucketList();
        return list;
    }

    @GetMapping(value="/list/add")
    public String bucket_add(HttpServletRequest request){
        String txt = BucketSer.insertList(request);

        return txt;
    }

    @GetMapping(value="/list/pick")
    public List<Bucket> bucket_own_list(HttpServletRequest request){
        List<Bucket> list = BucketSer.getOwnBucketList(request);
        return list;
    }


}
