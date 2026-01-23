package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/posting")
public class PostingRestController {

    Map<Integer, Object> postings = new HashMap<>();
    int sequence = 1;

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> map){
        System.out.println("map : " + map);
        int id = sequence++;
        map.put("id", id);
        map.put("createdAt", new Date());

        // can use map as a database
        postings.put(id, map);

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("status", 200);
        map_result.put("id", map.get("id") + "");

        System.out.println("postings : " + postings);

        return map_result;
    }

}
