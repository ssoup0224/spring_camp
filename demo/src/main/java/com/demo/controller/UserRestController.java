package com.demo.controller;

import com.demo.dto.DefaultDto;
import com.demo.dto.UserDto;
import com.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {
    final UserService userService;

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResponseDto> create(UserDto.CreateRequestDto param) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(param));
    }

    @PutMapping("")
    public ResponseEntity<Void> update(UserDto.UpdateRequestDto param) {
        userService.update(param);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(UserDto.UpdateRequestDto param) {
        userService.delete(param);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDto.DetailResponseDto>> list() {
        return ResponseEntity.ok(userService.list());
    }

    @GetMapping("")
    public ResponseEntity<UserDto.DetailResponseDto> detail(DefaultDto.DetailRequestDto param) {
        return ResponseEntity.ok(userService.detail(param));
    }


}
