package com.bucket.service;

import com.bucket.dao.MemberRepository;
import com.bucket.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepo;

    public List<Member> getMember(){
        List<Member> list = memberRepo.findAll();

        for(Member m : list){
            System.out.println(m.getName());
        }


        return list;
    }

    public Member checkMember(String id, String pw) {
//       return memberRepo.findByidAndpw(id,pw);
        Member member = new Member();
        return member;
    }
}
