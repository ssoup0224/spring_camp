package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

    @GetMapping("/list")
    public Map<String, Object> list(){
        List<Map<String, Object>> list = new ArrayList<>();

        // Method 1
//        Set<Integer> keys = postings.keySet();
//        Object[] array_key = keys.toArray();
//        Arrays.sort(array_key);
//
//        for(Object key : array_key){
//            list.add((Map<String, Object>) postings.get(key));
//        }

        // Method 2
        for(int i=0; i<sequence; i++){
           Object posting = postings.get(i);
           if(posting != null) list.add((Map<String, Object>) posting);
        }

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("status", 200);
        map_result.put("data", list);

        System.out.println("map_result : " + map_result);

        return map_result;
    }
}
