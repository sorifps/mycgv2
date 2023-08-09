package com.springboot.mycgv2.dto;

import java.util.ArrayList;

import lombok.Data;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Data
public class NoticeDto {
	String bnid, bntitle, bncontent, bndate, nfile1, nsfile1, nfile2, nsfile2;
	int rno, bnhits;
	CommonsMultipartFile[] files;
	ArrayList<String> nfile = new ArrayList<String>();
	ArrayList<String> nsfile = new ArrayList<String>();
	

}
