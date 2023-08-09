package com.springboot.mycgv2.repository;

import com.springboot.mycgv2.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageMapper {
    int totalRowCount(PageDto pageDto);











}
