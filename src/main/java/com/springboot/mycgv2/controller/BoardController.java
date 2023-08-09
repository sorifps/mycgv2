package com.springboot.mycgv2.controller;

import com.springboot.mycgv2.dto.BoardDto;
import com.springboot.mycgv2.dto.PageDto;
import com.springboot.mycgv2.service.BoardService;
import com.springboot.mycgv2.service.FileUploadService;
import com.springboot.mycgv2.service.PageService;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private PageService pageService;

    @Autowired
    private FileUploadService fileUploadService;


//    // 보드 json 게시물
//    @GetMapping("board_json_data/{page}")
//    public String board_json_data(@PathVariable String page, Model model){
//        model.addAttribute("page",page);
//    }

    // 보드 json 페이지
    @GetMapping("board_list_json")
    public String board_list_json(){
        return "/board/board_list_json";
    }

    // 글쓰기 삭제 완료
    @PostMapping("board_Delete")
    public String board_delete(BoardDto boardDto) throws Exception{
        String oldBsFile = boardService.bsFile(boardDto.getBid());
        int result = boardService.delete(boardDto.getBid());
        if(result == 1){
            if(!oldBsFile.equals("")){
                fileUploadService.fileDelete(oldBsFile);
            }
        }
        return "/board/board_list/1";
    }

    // 글쓰기 삭제 작업
    @GetMapping("board_delete/{bid}/{page}")
    public String board_delete(@PathVariable String bid,@PathVariable String page, Model model){
        model.addAttribute("bid",bid);
        model.addAttribute("page",page);

        return "/board/board_delete";
    }

    // 글쓰기 완료 작업
    @PostMapping("board_write")
    public String board_write_proc(BoardDto boardDto) throws Exception {
        //파일 업로드 서비스 추가
        boardDto = (BoardDto)fileUploadService.fileCheck(boardDto);
        int result = boardService.insert(boardDto);
        System.out.println(result);
        if(result == 1) fileUploadService.fileSave(boardDto);
        return "redirect:/board_list/1/";
    }

    // 글쓰기 진입 화면
    @GetMapping("board_write/{page}")
    public String borad_write(@PathVariable int page,Model model){
        model.addAttribute("page",page);

        return "/board/board_write";
    }

    // 업데이트 완료 작업
    @PostMapping("board_update")
    public String board_update_proc(BoardDto boardDto,Model model) throws Exception {
        //새로운 파일 선택시 기존파일 (oldFileName:bsfile) 삭제
        String oldBsFile = boardDto.getBsfile();
        boardDto = (BoardDto)fileUploadService.fileCheck(boardDto);
        int result = boardService.update(boardDto);
        if(result == 1) {
            if(!boardDto.getFile1().isEmpty()){
                fileUploadService.fileSave(boardDto);
                fileUploadService.fileDelete(oldBsFile);
            }
        }
//        if(boardService.update(boardDto) == 1){
//            model.addAttribute("bvo",boardService.content(boardDto.getBid()));
//        }else {
            //실패 페이지
//        }
        return "redirect:/board_list/"+boardDto.getPage()+"/";
//        return "/board/board_content/"+boardDto.getBid()+"/1/";
    }

    // 업데이트 진입 화면
    @GetMapping("board_update/{bid}")
    public String board_update(@PathVariable String bid,Model model){
        model.addAttribute("boardVo",boardService.content(bid));

        return "/board/board_update";
    }

    @GetMapping("board_content/{bid}/{page}")
    public String board_content(@PathVariable String bid, @PathVariable String page, Model model) {
        model.addAttribute("bvo",boardService.content(bid));
        model.addAttribute("page",page);
        return "/board/board_content";
    }

    @GetMapping("board_list/{page}")
    public String board_list(@PathVariable String page, Model model){
        PageDto pageDto = pageService.getPageResult(new PageDto(page,"board"));
        model.addAttribute("page", pageDto);
        model.addAttribute("list", boardService.list(pageDto));

        return "/board/board_list";

    }






}
