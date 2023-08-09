package com.springboot.mycgv2.service;

import com.springboot.mycgv2.dto.PageDto;
import com.springboot.mycgv2.repository.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService {
    @Autowired
    private PageMapper pageMapper;

    public PageDto getPageResult(PageDto pageDto){
        //페이징 처리 - startCount, endCount 구하기
        int startCount = 0;
        int endCount = 0;
        int pageSize = 10;	//한 페이지당 게시물 수
        int reqPage = 1;	//요청 페이지
        int pageCount = 1;	//전체 페이지 수
        int dbCount = 0;	//DB 총 보유 페이지 수

        dbCount = pageMapper.totalRowCount(pageDto);
        if(pageDto.getServiceName().equals("board")) {
            pageSize = 3;
        }else if(pageDto.getServiceName().equals("notice")) {
//			noticeService = (NoticeService)serviceType;
//			dbCount = pageDao.totalRowCount(serviceName);
            pageSize = 3;
        }else if(pageDto.getServiceName().equals("member")) {
//			memberService = (MemberService)serviceType;
//			dbCount = pageDao.totalRowCount(serviceName);
            pageSize = 10;
        }

        //�� ������ �� ���
        if(dbCount % pageSize == 0){
            pageCount = dbCount/pageSize;
        }else{
            pageCount = dbCount/pageSize+1;
        }

        //��û ������ ���
        if(pageDto.getPage() != null){
            reqPage = Integer.parseInt(pageDto.getPage());
            startCount = (reqPage-1) * pageSize+1;
            endCount = reqPage *pageSize;
        }else{
            startCount = 1;
            endCount = pageSize;
        }
        pageDto.setStartCount(startCount);
        pageDto.setEndCount(endCount);
        pageDto.setPageCount(pageCount);
        pageDto.setReqPage(reqPage);
        pageDto.setPageSize(pageSize);
        pageDto.setDbCount(dbCount);

        return pageDto;
    }


}
