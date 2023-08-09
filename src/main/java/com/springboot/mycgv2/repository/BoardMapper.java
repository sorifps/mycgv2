package com.springboot.mycgv2.repository;

import com.springboot.mycgv2.dto.BoardDto;
import com.springboot.mycgv2.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int delete(String bid);
    String bsFile(String bid);
    int insert(BoardDto boardDto);
    int update(BoardDto boardDto);
    BoardDto content(String bid);
    List<BoardDto> list(PageDto pageDto);
}
