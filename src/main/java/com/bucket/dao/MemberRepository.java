package com.bucket.dao;

import com.bucket.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByIdAndPw(String id, String pw);
}
