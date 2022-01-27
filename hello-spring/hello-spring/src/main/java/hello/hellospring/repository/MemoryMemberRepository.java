package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    //실무에서는 동시성 문제로 인해서 공유변수를 선언할때는 동시성 문제를 방지하고자
    //HashMap 대신 ConcurrentHashMap을 사용해야함
    private static long sequence = 0L;
    //sequence는 0,1,2... 키값을 생성해주는 역할

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //반환값이 null일때 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()//loop
                .filter(member -> member.getName().equals(name))//getName에서 받아온것들 중 매개변수 name과 같은것이 하나라도 있다면
                .findAny();//반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        //Map에 있는 value값들 : Member
    }

    public void clearStore(){
        store.clear();
    }
}
