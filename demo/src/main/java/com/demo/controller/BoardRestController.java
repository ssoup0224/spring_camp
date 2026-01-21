package com.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
public class BoardRestController {

    // 임시 정보 저장
    List<Map<String, Object>> list = new ArrayList<>();
    int id = 0;

    @RequestMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {
        String title = (String) params.get("title");
        String content = (String) params.get("content");
        String author = (String) params.get("author");

        // 아이디 값
        params.put("id", ++id);
        LocalDateTime now = LocalDateTime.now();
        params.put("createdAt", now);

        list.add(params);
        System.out.println(list.toString());

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("result_code", 200);

        return map_result;
    }

    @RequestMapping("/list")
    public Map<String, Object> list(@RequestParam Map<String, Object> params) {

        Map<String, Object> map_result2 = new HashMap<>();
        map_result2.put("result_code", 200);
        map_result2.put("list", list);

        return map_result2;
    }

    @RequestMapping("/detail")
    public Map<String, Object> detail(@RequestParam Map<String, Object> params) {

        String id = (String) params.get("id");

        Map<String, Object> map_board = null;
        for (Map<String, Object> each : list) {
            String tempId = each.get("id") + "";
            if (tempId.equals(id)) {
                map_board = each;
                break;
            }
        }

        Map<String, Object> map_result2 = new HashMap<>();
        map_result2.put("result_code", 200);
        map_result2.put("list", map_board);

        return map_result2;
    }

    @RequestMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params) {

        String id = (String) params.get("id");

        Map<String, Object> map_board = null;
        for (Map<String, Object> each : list) {
            String tempId = each.get("id") + "";
            if (tempId.equals(id)) {
                map_board = each;
            }
        }
        if (map_board != null) {
            String title = (String) params.get("title");
            if (title != null)
                map_board.put("title", title);
            String content = (String) params.get("content");
            if (content != null)
                map_board.put("content", content);
            String author = (String) params.get("author");
            if (author != null)
                map_board.put("author", author);
        }

        Map<String, Object> map_result = new HashMap<>();
        map_result.put("result_code", 200);

        return map_result;
    }
}
