package com.demo.service.impl;

import com.demo.service.BoardService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    // 임시 정보 저장
    List<Map<String, Object>> list = new ArrayList<>();
    int id = 0;

    @Override
    public Map<String, Object> create(Map<String, Object> params) {
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

    @Override
    public void update(int id, Map<String, Object> params) {
        Map<String, Object> map_board = null;
        for (Map<String, Object> each : list) {
            String tempId = each.get("id") + "";
            if (tempId.equals(id + "")) {
                map_board = each;
                break;
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
    }

    @Override
    public void delete(int id) {
        Map<String, Object> map_board = null;
        for (Map<String, Object> each : list) {
            String tempId = each.get("id") + "";
            if (tempId.equals(id + "")) {
                map_board = each;
            }
        }

        if (map_board != null) {
            map_board.put("title", null);
            map_board.put("content", null);
            map_board.put("author", null);
        }
    }

    @Override
    public Map<String, Object> detail(int id) {
        Map<String, Object> map_board = null;
        for (Map<String, Object> each : list) {
            String tempId = each.get("id") + "";
            if (tempId.equals(id + "")) {
                map_board = each;
                break;
            }
        }

        Map<String, Object> map_result2 = new HashMap<>();
        map_result2.put("result_code", 200);
        map_result2.put("list", map_board);

        return map_result2;
    }

    @Override
    public Map<String, Object> list() {
        Map<String, Object> map_result2 = new HashMap<>();
        map_result2.put("result_code", 200);
        map_result2.put("list", list);

        return map_result2;
    }
}
