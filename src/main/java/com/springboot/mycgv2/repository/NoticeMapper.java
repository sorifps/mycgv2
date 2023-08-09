package com.springboot.mycgv2.repository;

import com.springboot.mycgv2.dto.NoticeDto;
import com.springboot.mycgv2.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
    int delete(String bnid);
    int update(NoticeDto noticeDto);
    List<NoticeDto> list(PageDto pageDto);
    NoticeDto content(String bnid);
}
