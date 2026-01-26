package com.demo.service.impl;

import com.demo.domain.Posting;
import com.demo.dto.PostingDto;
import com.demo.repository.PostingRepository;
import com.demo.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostingServiceImpl implements PostingService {

    private final PostingRepository postingRepository;

    @Override
    public PostingDto.CreateResponseDto create(PostingDto.CreateRequestDto param) {
        Posting posting = new Posting();
        // Long id = Long.parseLong(map.get("id").toString());
        String title = param.getTitle();
        String content = param.getContent();
        String author = param.getAuthor();
        // posting.setId(id);
        posting.setTitle(title);
        posting.setContent(content);
        posting.setAuthor(author);
        postingRepository.save(posting);

        PostingDto.CreateResponseDto res = new PostingDto.CreateResponseDto();
        res.setId(posting.getId());
        return res;
    }

    @Override
    public void update(PostingDto.UpdateRequestDto param) {
        Long id = param.getId();
        Posting posting = postingRepository.findById(id).orElseThrow(() -> new RuntimeException("not data found"));

        if (param.getTitle() != null) {
            posting.setTitle(param.getTitle());
        }
        if (param.getContent() != null) {
            posting.setContent(param.getContent());
        }
        if (param.getAuthor() != null) {
            posting.setAuthor(param.getAuthor());
        }
        postingRepository.save(posting);
    }

    @Override
    public void delete(PostingDto.UpdateRequestDto param) {
        Long id = param.getId();
        Posting posting = postingRepository.findById(id).orElseThrow(() -> new RuntimeException("not data found"));
        postingRepository.delete(posting);
    }

    @Override
    public PostingDto.DetailResponseDto detail(PostingDto.DetailRequestDto param) {
        Long id = param.getId();
        Posting posting = postingRepository.findById(id).orElseThrow(() -> new RuntimeException("not data found"));

        PostingDto.DetailResponseDto res = toResponseDto(posting);
        return res;
    }

    @Override
    public List<PostingDto.DetailResponseDto> list() {
        List<Posting> list = postingRepository.findAll();

        List<PostingDto.DetailResponseDto> returnList = new ArrayList<>();
        for(Posting each : list) {
            PostingDto.DetailResponseDto res = toResponseDto(each);
            returnList.add(res);
        }
        return returnList;
    }

    public PostingDto.DetailResponseDto toResponseDto(Posting posting) {
        PostingDto.DetailResponseDto res = new PostingDto.DetailResponseDto();
        res.setId(posting.getId());
        res.setTitle(posting.getTitle());
        res.setContent(posting.getContent());
        res.setAuthor(posting.getAuthor());
        res.setCreatedAt(posting.getCreatedAt());
        res.setModifiedAt(posting.getModifedAt());
        return res;
    }
}
