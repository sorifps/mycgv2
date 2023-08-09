package com.springboot.mycgv2.repository;

import com.springboot.mycgv2.dto.MemberDto;
import com.springboot.mycgv2.dto.SessionDto;
import org.apache.ibatis.annotations.Mapper;

import java.lang.reflect.Member;

@Mapper
public interface MemberMapper {
    SessionDto login(MemberDto memberDto);

    int join(MemberDto memberDto);
    int idCheck(String id);









}
