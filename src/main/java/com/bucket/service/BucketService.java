package com.bucket.service;

import com.bucket.dao.BucketRepository;
import com.bucket.dao.MemberRepository;
import com.bucket.entity.Bucket;
import com.bucket.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BucketService {

    @Autowired
    private BucketRepository bucketRepo;

    public List<Bucket> getBucketList() {
        List<Bucket> list = bucketRepo.findAll();

        for(Bucket b : list){
            System.out.println(b.getTitle());
        }

        return list;
    }

    public String insertList(HttpServletRequest request) {
        String result = "bob";
        Bucket bucket = new Bucket();
        bucket.setTitle(request.getParameter("title"));
        bucket.setContent(request.getParameter("content"));
        bucket.setPermission(request.getParameter("permission"));
        bucket.setMainimg(request.getParameter("mainimg"));
        bucket.setDate(new Date());

        bucketRepo.save(bucket);

        return result;
    }


    public List<Bucket> getOwnBucketList(HttpServletRequest request) {

        HttpSession se = request.getSession();
        Member member = (Member) se.getAttribute("member");

        List<Bucket> list = new ArrayList<Bucket>();
        if(member != null){
            String id = member.getId();
             list = bucketRepo.findById(id);
        }

        for(Bucket b : list){
            System.out.println(b.getTitle());
        }

        return list;
    }
}
