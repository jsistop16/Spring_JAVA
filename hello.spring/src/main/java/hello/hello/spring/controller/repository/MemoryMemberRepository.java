package hello.hello.spring.controller.repository;

import hello.hello.spring.controller.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        //member들 이름중 매개변수로 넘어온 name과 같은것이 하나라도 있다면(findany)
        //Optional로 감싸서 반환됨
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        //store에서 value값은 Member!!
    }

    public void clearStore(){
            store.clear();
    }
}
