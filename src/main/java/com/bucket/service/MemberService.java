package com.bucket.service;

import com.bucket.dao.MemberRepository;
import com.bucket.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberService  {

    @Autowired
    private MemberRepository memberRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Member> getMember(){
        List<Member> list = memberRepo.findAll();

        for(Member m : list){
            System.out.println(m.getName());
        }


        return list;
    }

    public Member checkMember(String id, String pw) {
       return memberRepo.findByIdAndPw(id,pw);
    }

    public Member create(String id, String pw, String name){
        Member member = new Member();
        member.setId(id);
        member.setName(name);
        member.setPw(passwordEncoder.encode(pw));
        member.setDate(new Date());
        memberRepo.save(member);
        return member;
    }



}
