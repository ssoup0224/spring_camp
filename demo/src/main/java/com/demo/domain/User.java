package com.demo.domain;

import com.demo.dto.DefaultDto;
import com.demo.dto.UserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends AuditingFields {
    @Column(unique = true, nullable = false)
    String username; // 사용자 ID, Not null, unique
    @Column(nullable = false)
    String password;

    String name;
    String nickname;
    String phone;
    String birthday;
    Integer gender; // 10 : female, 20 : male

    protected User() {}
    private User(Boolean deleted, String username, String password, String name, String nickname, String phone, String birthday, Integer gender) {
        this.deleted = deleted;
        this.username = username;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
    }

    public static User of(String username, String password, String name, String nickname, String phone, String birthday, Integer gender) {
        return new User(false, username, password, name, nickname, phone, birthday, gender);
    }

    public DefaultDto.CreateResponseDto toCreateResponseDto() {
        return DefaultDto.CreateResponseDto.builder().id(getId()).build();
    }

    public void update(UserDto.UpdateRequestDto param) {
        if (param.getPassword() != null) {
            setPassword(param.getPassword());
        }
        if (param.getName() != null) {
            setName(param.getName());
        }
        if (param.getNickname() != null) {
            setNickname(param.getNickname());
        }
        if (param.getPhone() != null) {
            setPhone(param.getPhone());
        }
        if (param.getDeleted() != null) {
            setDeleted(param.getDeleted());
        }
    }
}
