package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



public class MemberService {
//ctrl+shift+t <-테스트 케이스 바로가기
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    //    회원가입
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원은 안된다
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())//변수 추출 MacOS: Cmd + Opt + v  Win/Linux: Ctrl + Alt + v
            .ifPresent(m -> {          //메서드 추출하기 (Extract -> Method) MacOS: Cmd + Opt + m Win/Linux: Ctrl + Alt + m
            throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }



    //전체 회원 조회
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
