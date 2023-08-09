package com.springboot.mycgv2.controller;

import com.springboot.mycgv2.dto.NoticeDto;
import com.springboot.mycgv2.dto.PageDto;
import com.springboot.mycgv2.service.NoticeService;
import com.springboot.mycgv2.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    NoticeService noticeService;
    @Autowired
    PageService pageService;


    //맴버 관리 매핑
    @GetMapping("member_list")
    public String admin_member_list(){
        return "/admin/member/admin_member_list";
    }

    //공지사항 삭제 완료 매핑
    @PostMapping("notice_delete")
    public String admin_notice_delete_proc(String bnid){
        int result = noticeService.delete(bnid);
        // 실패 페이지 viewName
        return "redirect:/admin/notice_list/1";
    }

    //공지사항 삭제 매핑
    @GetMapping("notice_delete/{bnid}")
    public String admin_notice_delete(@PathVariable String bnid,Model model){
        model.addAttribute("bnid",bnid);
        return "/admin/notice/admin_notice_delete";
    }

    //공지사항 수정 완료 매핑
    @PostMapping("notice_update")
    public String admin_notice_update_proc(NoticeDto noticeDto){
        int result = noticeService.update(noticeDto);
        //실패 페이지 viewName
        return "redirect:/admin/notice_content/"+noticeDto.getBnid()+"/1";
    }

    //공지사항 수정 매핑
    @GetMapping("notice_update/{bnid}")
    public String admin_notice_update(@PathVariable String bnid,Model model){
        model.addAttribute("boardNoticeVo",noticeService.content(bnid));
        return "/admin/notice/admin_notice_update";
    }


    //공지사항 컨텐츠 조회 매핑 (관리자 전용)
    @GetMapping("notice_content/{bnid}/{page}")
    public String admin_notice_content(@PathVariable String bnid,@PathVariable String page, Model model){
        model.addAttribute("boardNoticeVo",noticeService.content(bnid));
        model.addAttribute("page",page);
        return "/admin/notice/admin_notice_content";
    }

    //공지사항 글쓰기 매핑
    @GetMapping("notice_write")
    public String notice_write(){

        return "/admin/notice/admin_notice_write";
    }

    //공지사항 관리 매핑
    @GetMapping("notice_list/{page}")
    public String admin_notice_list(@PathVariable String page, Model model){
        PageDto pageDto = pageService.getPageResult(new PageDto(page, "notice"));
        model.addAttribute("list", noticeService.list(pageDto));
        model.addAttribute("page",pageDto);
        return "/admin/notice/admin_notice_list";
    }

    //어드민 페이지 매핑
    @GetMapping("index")
    public String admin_index(){
        return "/admin/admin_index";
    }
}
