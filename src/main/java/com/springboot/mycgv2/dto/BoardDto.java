package com.springboot.mycgv2.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BoardDto {
    String page;
    int rno, bhits;
    String bid, btitle, bcontent, id, bdate, bfile, bsfile;
    MultipartFile file1;
}
