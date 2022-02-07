package com.example.sessionDemo.service;

import com.example.sessionDemo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


}
