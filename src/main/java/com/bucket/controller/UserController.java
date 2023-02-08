package com.bucket.controller;

import com.bucket.entity.Member;
import com.bucket.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private MemberService memberSer;

    @GetMapping(value="/list")
    public String member_list(){
        List<Member> list = memberSer.getMember();
        System.out.println("good");
        return "good";
    }

    @GetMapping(value="/login")
    public String member_login(@RequestParam(value="id") String id,
                               @RequestParam(value="pw") String pw){

        Member member = memberSer.checkMember(id,pw);
        System.out.println(member.getName());

        return "good";


    }

}
