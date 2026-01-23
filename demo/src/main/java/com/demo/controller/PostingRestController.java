package com.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/posting")
public class PostingRestController {

    Map<Integer, Map<String, Object>> postings = new HashMap<>();
    int sequence = 1;

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> map) {
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
    public Map<String, Object> list() {
        List<Map<String, Object>> list = new ArrayList<>();

        // Method 1
        // Set<Integer> keys = postings.keySet();
        // Object[] array_key = keys.toArray();
        // Arrays.sort(array_key);
        //
        // for(Object key : array_key){
        // list.add((Map<String, Object>) postings.get(key));
        // }

        // Method 2
        for (int i = 0; i < sequence; i++) {
            Map<String, Object> posting = postings.get(i);
            if (posting != null)
                list.add(posting);
        }

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("status", 200);
        map_result.put("data", list);

        System.out.println("map_result : " + map_result);

        return map_result;
    }

    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam Integer id) {
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("status", 200);
        map_result.put("data", postings.get(id));
        return map_result;
    }

    @PutMapping("")
    public Map<String, Object> update(@RequestBody Map<String, Object> map) {
        Integer id = Integer.parseInt(map.get("id") + "");
        Map<String, Object> posting = postings.get(id);
        if (map.get("title") != null)
            posting.put("title", map.get("title"));
        if (map.get("content") != null)
            posting.put("content", map.get("content"));

        postings.put(id, posting);

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("status", 200);

        return map_result;
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Integer id) {
        postings.remove(id);
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("status", 200);
        return map_result;
    }
}
