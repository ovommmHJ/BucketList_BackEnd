package com.bucket.controller;

import com.bucket.entity.Member;
import com.bucket.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    public Member member_login(@RequestParam(value="id") String id,
                               @RequestParam(value="pw") String pw){

        Member member = memberSer.checkMember(id,pw);
        System.out.println(member.getName());

        return member;
    }


    @GetMapping(value="/join")
    public String member_join(@RequestParam(value="id")String id,
                              @RequestParam(value="pw")String pw,
                              @RequestParam(value="name")String name){

        // 결과 문자열을 저장할 변수
        String result ="";

        try {
            // 회원 생성 메서드 호출
            Member member = memberSer.create(id,pw,name);
            result = "성공";
        }catch(DataIntegrityViolationException e){
            // 동일한 아이디가 이미 존재할 경우
            e.printStackTrace();
            result = "동일한 아이디가 존재합니다.";
        }catch(Exception e) {
            // 기타 예외
            e.printStackTrace();
            result="회원가입 실패";
        }

        // 결과 문자열 반환
        return result;

    }


}
