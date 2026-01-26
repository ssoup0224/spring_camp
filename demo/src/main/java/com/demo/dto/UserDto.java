package com.demo.dto;


import com.demo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class UserDto {
    @Getter
    @Setter
    public static class CreateRequestDto {
        String username;
        String password;
        String name;
        String nickname;
        String phone;
        String birthday;
        Integer gender;

        public User toEntity() {
            return User.of(username, password, name, nickname, phone, birthday, gender);
        }
    }

    @Getter @Setter @SuperBuilder
    @NoArgsConstructor @AllArgsConstructor
    public static class UpdateRequestDto extends DefaultDto.UpdateRequestDto {
        String password;
        String name;
        String nickname;
        String phone;
    }

    @Getter @Setter @SuperBuilder
    @NoArgsConstructor @AllArgsConstructor
    public static class DetailResponseDto extends DefaultDto.DetailResponseDto {
        String username;
        String name;
        String nickname;
        String phone;
        String birthday;
        Integer gender;
    }
}
