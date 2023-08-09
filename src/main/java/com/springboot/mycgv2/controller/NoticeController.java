package com.springboot.mycgv2.controller;

import com.springboot.mycgv2.dto.PageDto;
import com.springboot.mycgv2.service.NoticeService;
import com.springboot.mycgv2.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @Autowired
    PageService pageService;


    @GetMapping("notice_content/{bnid}/{page}")
    public String notice_content(@PathVariable String bnid,@PathVariable Integer page, Model model) {
        model.addAttribute("boardNoticeVo",noticeService.content(bnid));
        model.addAttribute("page",page);

        return "/notice/notice_content";
    }

    @GetMapping("notice_list/{page}")
    public String notice_list(@PathVariable String page, Model model){
        PageDto pageDto = pageService.getPageResult(new PageDto(page, "notice"));
        model.addAttribute("list",noticeService.list(pageDto));
        model.addAttribute("page", pageDto);

        return "/notice/notice_list";
    }









}
