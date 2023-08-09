package com.springboot.mycgv2.service;

import com.springboot.mycgv2.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
public class FileUploadService {


//    public void multiFileSave(BoardDto boardDto, HttpServletRequest request) throws Exception {
//        String root_path = request.getSession().getServletContext().getRealPath("/");
//        String attach_path = "\\resources\\upload\\";
//        int count = 0;
//        for(CommonsMultipartFile file : boardNoticeVo.getFiles()) {
//
//            if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
//                File saveFile = new File(root_path + attach_path + boardNoticeVo.getNsfile().get(count));
//                file.transferTo(saveFile);
//                count++;
//            }
//        }
//    }

//    public BoardNoticeVo multiFileCheck(BoardNoticeVo boardNoticeVo) {
//        for(CommonsMultipartFile file : boardNoticeVo.getFiles()) {
//            if(!file.getOriginalFilename().equals("")) {
//                //파일이 있으면
//                UUID uuid = UUID.randomUUID();
//                boardNoticeVo.getNfile().add(file.getOriginalFilename()); //첫번째 어레이 리스트에 넣기
//                boardNoticeVo.getNsfile().add(uuid+"_"+file.getOriginalFilename()); //첫번째 어레이 리스트에 넣기
//            }else {
//                //없으면
//                boardNoticeVo.getNfile().add("");
//                boardNoticeVo.getNsfile().add("");
//            }
//        }//for
//
//        boardNoticeVo.setNfile1(boardNoticeVo.getNfile().get(0));
//        boardNoticeVo.setNsfile1(boardNoticeVo.getNsfile().get(0));
//        boardNoticeVo.setNfile2(boardNoticeVo.getNfile().get(1));
//        boardNoticeVo.setNsfile2(boardNoticeVo.getNsfile().get(1));
//
//        return boardNoticeVo;
//    }

    public void fileDelete(String oldFileName) throws Exception {
//        String root_path = request.getSession().getServletContext().getRealPath("/");
        String attach_path = "\\resources\\upload\\";

//        if(oldFileName != null && !oldFileName.equals("")) { //새로운 파일이 선택이 되면 기존이름이 없으면
//            File deleteFile = new File(root_path + attach_path + oldFileName);
//            if(deleteFile.exists()) {
//                deleteFile.delete();
//            }
//        }
    }

    /*
     *  fileDelete 기능 - 파일 수정 저장 전 파일 삭제
     */
    public void fileDelete(BoardDto boardDto, String oldFileName) throws Exception {

        if(!boardDto.getFile1().getOriginalFilename().equals("")) { //새로운 파일이 선택이 되면 기존이름이 있으며
            String projectPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\upload\\";

            File deleteFile = new File(projectPath+ boardDto.getBsfile());
            System.out.println(deleteFile);
            if(deleteFile.exists()) {
                System.out.println("진입");
                deleteFile.delete();
            }
        }
    }


    /*
     *  fileSave 기능 - 파일이 존재하면 서버에 저장하는 메소드
     */
    public void fileSave(BoardDto boardDto) throws Exception{

        //파일의 저장위치
        String projectPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\upload\\";
        System.out.println("path="+ projectPath);


        if(boardDto.getBfile() != null && !boardDto.getBfile().equals("")) {
            System.out.println("save file > "+ boardDto.getBfile());
            File saveFile = new File(projectPath + boardDto.getBsfile());
            boardDto.getFile1().transferTo(saveFile);
        }

    }

    /*
     * fileCheck 기능 - 파일이 존재하면 boardVo에 bfile, bsfile set!, 없으면 boardVo
     */

    public Object fileCheck(BoardDto boardDto) {
        if(boardDto.getFile1().getOriginalFilename() != null) { //������ ������
            //������ ������ġ ���� ����

            //rfname �ߺ����� ó��
            UUID uuid = UUID.randomUUID(); // �ߺ������� ���� �ο��� ���� UUID ����
            String bfile = boardDto.getFile1().getOriginalFilename();
            String bsfile = uuid + "_" + bfile;
            boardDto.setBfile(bfile);
            boardDto.setBsfile(bsfile);
        }else {
            boardDto.setBfile("");
            boardDto.setBsfile("");
        }
        return boardDto;
    }













}
