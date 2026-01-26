package com.demo.service.impl;

import com.demo.domain.User;
import com.demo.dto.DefaultDto;
import com.demo.dto.UserDto;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public DefaultDto.CreateResponseDto create(UserDto.CreateRequestDto param) {
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
        for(User each : list) {
            res.add(get(each.getId()));
        }
        return List.of();
    }

    public UserDto.DetailResponseDto get(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        UserDto.DetailResponseDto res = UserDto.DetailResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .nickname(user.getNickname())
                .phone(user.getPhone())
                .birthday(user.getBirthday())
                .gender(user.getGender())
                .build();
        return res;
    }
}
