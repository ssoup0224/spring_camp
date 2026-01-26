package com.demo.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class User extends AuditingFields{
    String username;
    String password;

    String name;
    String nickname;
    String birthday;
    Integer gender; // 10 : female, 20 : male

    protected User() {}
    private User(String username, String password, String name, String nickname, String birthday, Integer gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.birthday = birthday;
        this.gender = gender;
    }

    public static User of(String username, String password, String name, String nickname, String birthday, Integer gender) {
        return new User(username, password, name, nickname, birthday, gender);
    }
}
