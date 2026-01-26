package com.demo.dto;

import com.demo.domain.Posting;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
    @SuperBuilder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequestDto extends DefaultDto.UpdateRequestDto {
        String title;
        String content;
        String author;
    }

    @Getter
    @Setter
    @SuperBuilder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetailResponseDto extends DefaultDto.DetailResponseDto{
        String title;
        String content;
        String author;
    }
}
