package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class MemberController {

//    @Autowired private MemberService memberService; 필드주입(가급적 사용 x)
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) { //이렇게 생성자 주입이 깔끔
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public  String creatFrom() {
        return "members/createMemberForm";
    } //getmapping은 url창 엔터 딱치는거

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName()); //확인용

        memberService.join(member);

        return  "redirect:/";
    } //데이타를 뭔가 폼같은데 넣어서 전달할때 postmapping
}
