package com.demo.service;

import com.demo.dto.DefaultDto;
import com.demo.dto.UserDto;
import com.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    DefaultDto.CreateResponseDto create(UserDto.CreateRequestDto param);
    void update(UserDto.UpdateRequestDto userDto);
    void delete(UserDto.UpdateRequestDto userDto);
    UserDto.DetailResponseDto detail(DefaultDto.DetailRequestDto param);
    List<UserDto.DetailResponseDto> list();
}
