package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean//Service를 스프링 컨테이너에 등록
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean//Repository를 스프링 컨테이너에 등록
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
