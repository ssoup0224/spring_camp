package com.demo.mapper;

import com.demo.dto.PostingDto;

import java.util.List;

public interface PostingMapper {
    PostingDto.DetailResDto detail(Long id);
    List<PostingDto.DetailResDto> list(PostingDto.ListReqDto param);
    int listCount(PostingDto.PagedListReqDto param);
    List<PostingDto.DetailResDto> pagedList(PostingDto.PagedListReqDto param);
    List<PostingDto.DetailResDto> scrolledList(PostingDto.ScrolledListReqDto param);
}