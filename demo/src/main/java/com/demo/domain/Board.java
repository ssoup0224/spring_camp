package com.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // DB Table
public class Board {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK로 사용됨 (중복불가, 없으면 안됨)
    private String title;
    private String content;
    private String author;
}
