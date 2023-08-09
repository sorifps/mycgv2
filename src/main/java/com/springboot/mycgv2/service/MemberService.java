package com.springboot.mycgv2.service;

import com.springboot.mycgv2.dto.MemberDto;
import com.springboot.mycgv2.dto.SessionDto;
import com.springboot.mycgv2.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;

    public int join(MemberDto memberDto){
        return memberMapper.join(memberDto);
    }

    public int idCheck(String id){
        return memberMapper.idCheck(id);
    }


    public SessionDto login(MemberDto memberDto){

        return memberMapper.login(memberDto);
    }







}
