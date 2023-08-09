package com.springboot.mycgv2.service;

import com.springboot.mycgv2.dto.NoticeDto;
import com.springboot.mycgv2.dto.PageDto;
import com.springboot.mycgv2.repository.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    //공지사항 삭제 (관리자)
    public int delete(String bnid){ return noticeMapper.delete(bnid);}

    //공지사항 수정 (관리자)
    public int update(NoticeDto noticeDto) { return noticeMapper.update(noticeDto); }

    public NoticeDto content(String bnid){
        return noticeMapper.content(bnid);
    }

    public List<NoticeDto> list(PageDto pageDto){
        return noticeMapper.list(pageDto);
    }




}
