package com.demo.service.impl;

import com.demo.domain.Posting;
import com.demo.dto.DefaultDto;
import com.demo.dto.PostingDto;
import com.demo.dto.PostingimgDto;
import com.demo.mapper.PostingMapper;
import com.demo.repository.PostingRepository;
import com.demo.service.PostingService;
import com.demo.service.PostingimgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostingServiceImpl implements PostingService {

    final PostingRepository postingRepository;
    final PostingMapper postingMapper;
    final PostingimgService postingimgService;

    /**/

    @Override
    public DefaultDto.CreateResDto create(PostingDto.CreateReqDto param) {
        List<String> imgs = param.getImgs();
        if (imgs != null && !imgs.isEmpty()) {
            param.setImg(imgs.get(0));
        }
        DefaultDto.CreateResDto res = postingRepository.save(param.toEntity()).toCreateResDto();
        for (String img : imgs) {
            // 저장해줘야 함!
            postingimgService.create(PostingimgDto.CreateReqDto.builder().postingId(res.getId()).img(img).build());
        }
        return res;
    }

    @Override
    public void update(PostingDto.UpdateReqDto param) {
        Posting posting = postingRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        posting.update(param);
        postingRepository.save(posting);
    }

    @Override
    public void delete(PostingDto.UpdateReqDto param) {
        update(PostingDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public PostingDto.DetailResDto get(Long id) {
        PostingDto.DetailResDto res = postingMapper.detail(id);
        if (res == null) {
            return null;
        }
        List<PostingimgDto.DetailResDto> imgs = postingimgService
                .list(PostingimgDto.ListReqDto.builder().deleted(false).postingId(res.getId()).build());
        res.setImgs(imgs);

        return res;
    }

    @Override
    public PostingDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param.getId());
    }

    public List<PostingDto.DetailResDto> detailList(List<PostingDto.DetailResDto> list) {
        List<PostingDto.DetailResDto> newList = new ArrayList<>();
        for (PostingDto.DetailResDto each : list) {
            newList.add(get(each.getId()));
        }
        return newList;
    }

    @Override
    public List<PostingDto.DetailResDto> list(PostingDto.ListReqDto param) {
        param.init();
        List<PostingDto.DetailResDto> res = postingMapper.list(param);
        return detailList(res);
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(PostingDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto res = param.init(postingMapper.listCount(param));
        res.setList(detailList(postingMapper.pagedList(param)));
        return res;
    }

    @Override
    public List<PostingDto.DetailResDto> scrolledList(PostingDto.ScrolledListReqDto param) {
        param.init();
        if (param.getCursor() != null && "title".equals(param.getOrderby())) {
            Long id = param.getCursor();
            Posting posting = postingRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
            param.setCursorsearch(posting.getTitle() + "_" + id);
        }
        List<PostingDto.DetailResDto> list = postingMapper.scrolledList(param);
        return detailList(list);
    }
}
