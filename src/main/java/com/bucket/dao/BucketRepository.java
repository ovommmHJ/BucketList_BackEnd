package com.bucket.dao;

import com.bucket.entity.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BucketRepository extends JpaRepository<Bucket,Long> {

    List<Bucket> findById(String id);
}
