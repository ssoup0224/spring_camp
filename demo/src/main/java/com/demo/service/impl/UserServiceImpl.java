package com.demo.service.impl;

import com.demo.domain.User;
import com.demo.dto.DefaultDto;
import com.demo.dto.UserDto;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public DefaultDto.CreateResponseDto login(UserDto.LoginRequestDto param) {
        // Method 1
//        User user = userRepository.findByUsername(param.getUsername());
//        if (user != null && user.getPassword().equals(param.getPassword())) {
//            return DefaultDto.CreateResponseDto.builder().id(user.getId()).build(); // 로그인 성공
//        }

        // Method 2 (using without Optional)
        User user = userRepository.findByUsernameAndPassword(param.getUsername(), param.getPassword());
        if (user != null) {
            return DefaultDto.CreateResponseDto.builder().id(user.getId()).build();
        }

        return DefaultDto.CreateResponseDto.builder().id((long) -200).build(); // 로그인 실패

        // Method 3 (using Optional in repository)
//        User user = userRepository.findByUsernameAndPassword(param.getUsername(), param.getPassword()).orElseThrow(() -> new RuntimeException("User not found"));
//
//        return DefaultDto.CreateResponseDto.builder().id(user.getId()).build();
    }

    @Override
    public DefaultDto.CreateResponseDto create(UserDto.CreateRequestDto param) {
        User user = userRepository.findByUsername(param.getUsername());
        if (user != null) {
            // Method 1
            // throw new RuntimeException("User already exists");
            // Method 2
            return DefaultDto.CreateResponseDto.builder().id((long)-100).build();
        }
        return userRepository.save(param.toEntity()).toCreateResponseDto();
    }

    @Override
    public void update(UserDto.UpdateRequestDto param) {
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        user.update(param);
        userRepository.save(user);
    }

    @Override
    public void delete(UserDto.UpdateRequestDto param) {
        update(UserDto.UpdateRequestDto.builder().id(param.getId()).deleted(true).build());
    }

    @Override
    public UserDto.DetailResponseDto detail(DefaultDto.DetailRequestDto param) {
        return get(param.getId());
    }

    @Override
    public List<UserDto.DetailResponseDto> list() {
        List<User> list = userRepository.findAll();
        List<UserDto.DetailResponseDto> res = new ArrayList<>();
        for (User each : list) {
            res.add(get(each.getId()));
        }
        return res;
    }

    public UserDto.DetailResponseDto get(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return UserDto.DetailResponseDto.builder()
                .id(user.getId())
                .deleted(user.getDeleted())
                .createdAt(user.getCreatedAt())
                .modifiedAt(user.getModifiedAt())
                .username(user.getUsername())
                .name(user.getName())
                .nickname(user.getNickname())
                .phone(user.getPhone())
                .birthday(user.getBirthday())
                .gender(user.getGender())
                .build();
    }
}
