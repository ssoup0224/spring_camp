package com.demo.service.impl;

import com.demo.domain.Posting;
import com.demo.repository.PostingRepository;
import com.demo.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostingServiceImpl implements PostingService {

    private final PostingRepository postingRepository;

    @Override
    public Map<String, Object> create(Map<String, Object> map) {
        Posting posting = new Posting();
        // Long id = Long.parseLong(map.get("id").toString());
        String title = map.get("title") + "";
        String content = map.get("content") + "";
        String author = map.get("author") + "";
        // posting.setId(id);
        posting.setTitle(title);
        posting.setContent(content);
        posting.setAuthor(author);
        postingRepository.save(posting);

        Map<String, Object> result = new HashMap<>();
        result.put("result_code", 200);
        result.put("id", posting.getId());
        return result;
    }

    @Override
    public void update(Map<String, Object> map) {
        Long id = Long.parseLong(map.get("id") + "");
        Posting posting = postingRepository.findById(id).orElseThrow(() -> new RuntimeException("not data found"));

        if (map.get("title") != null) {
            posting.setTitle(map.get("title") + "");
        }
        if (map.get("content") != null) {
            posting.setContent(map.get("content") + "");
        }
        if (map.get("author") != null) {
            posting.setAuthor(map.get("author") + "");
        }
        postingRepository.save(posting);
    }

    @Override
    public void delete(Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(() -> new RuntimeException("not data found"));
        postingRepository.delete(posting);
    }

    @Override
    public Map<String, Object> detail(Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(() -> new RuntimeException("not data found"));

        Map<String, Object> result = new HashMap<>();
        result.put("result_code", 200);
        result.put("data", posting);
        return result;
    }

    @Override
    public Map<String, Object> list() {
        List<Posting> list = postingRepository.findAll();

        Map<String, Object> result = new HashMap<>();
        result.put("result_code", 200);
        result.put("data", list);
        return result;
    }
}
