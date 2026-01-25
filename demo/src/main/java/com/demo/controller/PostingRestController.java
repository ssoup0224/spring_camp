package com.demo.controller;

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
    public Map<String, Object> create(@RequestBody Map<String, Object> map) {
        return postingService.create(map);
    }

    @GetMapping("/list")
    public Map<String, Object> list() {
        return postingService.list();
    }

    @GetMapping("")
    public Map<String, Object> detail(@RequestParam Long id) {
        return postingService.detail(id);
    }

    @PutMapping("")
    public void update(@RequestBody Map<String, Object> map) {
        postingService.update(map);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Long id) {
        postingService.delete(id);
    }
}
