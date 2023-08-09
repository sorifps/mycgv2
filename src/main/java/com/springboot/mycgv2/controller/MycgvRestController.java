package com.springboot.mycgv2.controller;

import com.springboot.mycgv2.dto.BoardDto;
import com.springboot.mycgv2.dto.MemberDto;
import com.springboot.mycgv2.dto.PageDto;
import com.springboot.mycgv2.service.BoardService;
import com.springboot.mycgv2.service.MemberService;
import com.springboot.mycgv2.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MycgvRestController {

    @Autowired
    MemberService memberService;

    @Autowired
    BoardService boardService;

    @Autowired
    PageService pageService;

    //JSON Update Page
    @GetMapping("board_update_json_data/{bid}/{page}")
    public Map board_update_json_data(@PathVariable String bid,@PathVariable String page){
        Map map = new HashMap();
        map.put("content", boardService.content(bid));
        map.put("page", page);
        return map;
    }

    //JSON Content
    @GetMapping("board_content_json_data/{bid}")
    public BoardDto board_content_json_data(@PathVariable String bid){
        return boardService.content(bid);
    }

    //JSON
    @GetMapping("board_list_json_data/{page}")
    public Map board_list_json_data(@PathVariable String page){ //리턴타입없이 그대로 넘어갈수 있다. 어레이 LIST
        Map map = new HashMap();
        PageDto pageDto = pageService.getPageResult(new PageDto(page, "board")); //페이지 서비스에서 DTO를 만들면서 어떤 서비스인지 입력.
        List<BoardDto> list = boardService.list(pageDto);
        map.put("list", list);
        map.put("page",pageDto);
        return map;
    }

    @GetMapping("idCheck/{id}")
    public String idCheck(@PathVariable String id){
//        System.out.println(id);
//        int result = memberService.idCheck(id);


        return String.valueOf(memberService.idCheck(id)) ;
    }











}

