package com.springboot.mycgv2.service;

import com.springboot.mycgv2.dto.BoardDto;
import com.springboot.mycgv2.dto.PageDto;
import com.springboot.mycgv2.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.xpath.XPathFunctionException;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;


    public int delete(String bid){
        return boardMapper.delete(bid);
    }
    public String bsFile(String bid){
        return boardMapper.bsFile(bid);
    }

    public int insert(BoardDto boardDto) { return boardMapper.insert(boardDto);}

    public int update(BoardDto boardDto){
        return boardMapper.update(boardDto);
    }

    public BoardDto content(String bid){
        return boardMapper.content(bid);
    }

    public List<BoardDto> list(PageDto pageDto){
        return boardMapper.list(pageDto);
    }

}
