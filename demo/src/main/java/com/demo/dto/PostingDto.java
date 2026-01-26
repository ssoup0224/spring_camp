package com.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class PostingDto {
    @Getter
    @Setter
    public static class CreateRequestDto {
        String title;
        String content;
        String author;
    }

    @Getter
    @Setter
    public static class CreateResponseDto {
        Long id;
    }

    @Getter
    @Setter
    public static class UpdateRequestDto {
        Long id;
        String title;
        String content;
        String author;
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
