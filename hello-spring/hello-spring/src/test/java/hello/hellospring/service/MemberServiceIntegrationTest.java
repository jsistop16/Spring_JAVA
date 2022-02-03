package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//DB까지 연동해서 한번에 테스트
@SpringBootTest
@Transactional//테스트가 끝나면 db 롤백해줌(데이터 삭제)
    //테스트 메소드 마다 롤백해줌
    //다음 테스트를 반복해서 실행할수있음
class MemberServiceIntegrationTest {
    //스프링 띄워서 테스트 = 통합테스트

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    void join() {//회원가입
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
//        방법3(예외를 변수로 처리e)
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        방법2(assertThrows)
//        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        방법1(try-catch)
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //then

    }

    @Test
    void findMembers() {
        //given

        //when

        //then

    }

    @Test
    void findOne() {
        //given

        //when

        //then

    }
}