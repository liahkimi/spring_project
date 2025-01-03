package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {


    // 회원의 id를 저장
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 8L;

    @Override // 회원 저장 
    public Member save(Member member) {
        member.setId(sequence++); //회원번호 증가
        store.put(member.getId(),member); //회원의 이름을 가져와서 저장
        return member;
    }

    @Override // 회원번호로 회원 찾기
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override // 회원이름으로 회원찾기
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 이름으로 찾으면 반환
    }

    @Override // 모든 회원 조회
    public List<Member> findAll() {
        return new ArrayList<>(store.values());

    }
}
