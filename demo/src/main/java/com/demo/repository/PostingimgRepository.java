package com.demo.repository;

import com.demo.domain.Postingimg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingimgRepository extends JpaRepository<Postingimg, Long> {
}
