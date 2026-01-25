package com.demo.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface PostingService {
     public Map<String, Object> create(Map<String, Object> map);
     public void update(Map<String, Object> map);
     public void delete(Long id);
     public Map<String, Object> detail(Long id);
     public Map<String, Object> list();
}
