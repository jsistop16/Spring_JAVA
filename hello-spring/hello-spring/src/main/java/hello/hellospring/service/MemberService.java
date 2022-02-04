package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional//jpa를 사용하기위해서는 transactional이 있어야함
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
        회원가입
         */
    public long join(Member member) {
        //비지니스 로직 : 같은 이름의 중복회원 불가
        validateDuplicateMember(member);//중복회원 검증 메소드
        memberRepository.save(member);
        return member.getId();
//        long start = System.currentTimeMillis();
//        try{
//            validateDuplicateMember(member);
//            memberRepository.save(member);
//            return member.getId();
//        }finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join method time = " + timeMs + "ms");
//        }//aop를 적용하면 안해도 됨

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /*
    전체회원조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
