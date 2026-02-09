package com.demo.mapper;

import com.demo.dto.UserDto;

import java.util.List;

public interface UserMapper {
    UserDto.DetailResponseDto detail(Long id);
    List<UserDto.DetailResponseDto> list(UserDto.L);
}
