package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {


    // 회원의 id를 저장
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 8L;

    @Override
    public Member save(Member member) {
        member.setId(sequence++); //회원번호 증가
        store.put(member.getId(),member); //회원의 이름을 가져와서 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }
}
