package com.demo.dto;

import com.demo.domain.Posting;
import lombok.*;

import java.time.LocalDateTime;

public class PostingDto {
    @Getter
    @Setter
    public static class CreateRequestDto {
        String title;
        String content;
        String author;

        public Posting toEntity() {
            return Posting.of(title, content, author);
        }
    }

    @Getter
    @Setter
    @Builder
    public static class CreateResponseDto {
        Long id;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequestDto {
        Long id;
        String title;
        String content;
        String author;
        Boolean deleted;
    }

    @Getter
    @Setter
    public static class DetailRequestDto {
        Long id;
    }

    @Getter
    @Setter
    public static class DetailResponseDto {
        Long id;
        String title;
        String content;
        String author;
        LocalDateTime createdAt;
        LocalDateTime modifiedAt;
    }
}
