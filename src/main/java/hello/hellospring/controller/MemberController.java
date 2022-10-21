package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller

public class MemberController {

//    @Autowired private MemberService memberService; 필드주입(가급적 사용 x)
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) { //이렇게 생성자 주입이 깔끔
        this.memberService = memberService;
    }
}
