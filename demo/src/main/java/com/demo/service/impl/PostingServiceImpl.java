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
        return postingRepository.save(param.toEntity()).toCreateResponseDto();
    }

    @Override
    public void update(PostingDto.UpdateRequestDto param) {
        Long id = param.getId();
        Posting posting = postingRepository.findById(id).orElseThrow(() -> new RuntimeException("not data found"));

        posting.update(param);
        postingRepository.save(posting);
    }

    @Override
    public void delete(PostingDto.UpdateRequestDto param) {
        // 완전삭제
//        Long id = param.getId();
//        Posting posting = postingRepository.findById(id).orElseThrow(() -> new RuntimeException("not data found"));
//        postingRepository.delete(posting);
        // soft delete
        update(PostingDto.UpdateRequestDto.builder().id(param.getId()).deleted(true).build());
    }

    @Override
    public PostingDto.DetailResponseDto detail(PostingDto.DetailRequestDto param) {
        Posting posting = postingRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("not data found"));

        return toResponseDto(posting);
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
