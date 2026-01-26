package com.demo.service;

import com.demo.dto.PostingDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PostingService {
     public PostingDto.CreateResponseDto create(PostingDto.CreateRequestDto param);
     public void update(PostingDto.UpdateRequestDto param   );
     public void delete(PostingDto.UpdateRequestDto param);
     public PostingDto.DetailResponseDto detail(PostingDto.DetailRequestDto param);
     public List<PostingDto.DetailResponseDto> list();
}
