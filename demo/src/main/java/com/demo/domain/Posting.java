package com.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Posting extends AuditingFields {
    private String title;
    private String content;
    private String author;

    // 외부에서 사용 못하게 하려고함
    protected Posting() {}
    // 외부에서 사용불가
    private Posting(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 이 메서드를 통해서만 엔티티의 인스턴스 만들기
    public static Posting of(String title, String content, String author) {
        return new Posting(title, content, author);
    }
}
