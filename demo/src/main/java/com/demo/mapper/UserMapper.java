package com.demo.mapper;

import com.demo.dto.UserDto;

import java.util.List;

public interface UserMapper {
    // 조회 하는데 사용될 디오
    UserDto.DetailResponseDto detail(Long id);
    List<UserDto.DetailResponseDto> list();
}
