package com.demo.controller;

import com.demo.dto.PostingDto;
import com.demo.service.PostingService;
import lombok.RequiredArgsConstructor;
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
    public PostingDto.CreateResponseDto create(@RequestBody PostingDto.CreateRequestDto param) {
        return postingService.create(param);
    }

    @GetMapping("/list")
    public List<PostingDto.DetailResponseDto> list() {
        return postingService.list();
    }

    @GetMapping("")
    public PostingDto.DetailResponseDto detail(PostingDto.DetailRequestDto param) {
        return postingService.detail(param);
    }

    @PutMapping("")
    public void update(@RequestBody PostingDto.UpdateRequestDto param) {
        postingService.update(param);
    }

    @DeleteMapping("")
    public void delete(@RequestBody PostingDto.UpdateRequestDto param) {
        postingService.delete(param);
    }
}
