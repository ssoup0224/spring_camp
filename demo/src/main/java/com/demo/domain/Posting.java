package com.demo.domain;

import com.demo.dto.DefaultDto;
import com.demo.dto.PostingDto;
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
    private Posting(Boolean deleted, String title, String content, String author) {
        this.deleted = deleted;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 이 메서드를 통해서만 엔티티의 인스턴스 만들기
    public static Posting of(String title, String content, String author) {
        return new Posting(false, title, content, author);
    }

    // create하고난 후, 해야 할 일
    public DefaultDto.CreateResponseDto toCreateResponseDto() {
        return DefaultDto.CreateResponseDto.builder().id(getId()).build();
    }

    public void update(PostingDto.UpdateRequestDto param) {
        if (param.getTitle() != null) {
            setTitle(param.getTitle());
        }
        if (param.getContent() != null) {
            setContent(param.getContent());
        }
        if (param.getAuthor() != null) {
            setAuthor(param.getAuthor());
        }
        if (param.getDeleted() != null) {
            setDeleted(param.getDeleted());
        }
    }
}
