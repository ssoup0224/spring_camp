package com.demo.controller;

import com.demo.dto.PostingDto;
import com.demo.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posting")
public class PostingRestController {

    private final PostingService postingService;

//    Map<Integer, Map<String, Object>> postings = new HashMap<>();
//    int sequence = 1;

    @PostMapping("")
    public ResponseEntity<PostingDto.CreateResponseDto> create(@RequestBody PostingDto.CreateRequestDto param) {
        // return postingService.create(param);
        return ResponseEntity.status(HttpStatus.CREATED).body(postingService.create(param));
    }

    @GetMapping("/list")
    public ResponseEntity<List<PostingDto.DetailResponseDto>> list() {
        return ResponseEntity.ok(postingService.list());
    }

    @GetMapping("")
    public ResponseEntity<PostingDto.DetailResponseDto> detail(PostingDto.DetailRequestDto param) {
        return ResponseEntity.ok(postingService.detail(param));
    }

    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody PostingDto.UpdateRequestDto param) {

        postingService.update(param);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody PostingDto.UpdateRequestDto param) {
        postingService.delete(param);
        return ResponseEntity.ok().build();
    }
}
