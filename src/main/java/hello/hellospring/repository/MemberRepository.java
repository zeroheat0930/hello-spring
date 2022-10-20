package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //옵셔널은 findbyid나 name 가져올때 널일때 널 반환
    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금까지 저장된 리스트 회원 다 반환
}
