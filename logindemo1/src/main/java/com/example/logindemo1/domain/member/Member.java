package com.example.logindemo1.domain.member;

import lombok.Data;

//회원 도메인
@Data
public class Member {
    private Long id;
    private String loginId;
    private String name;
    private String password;

}
