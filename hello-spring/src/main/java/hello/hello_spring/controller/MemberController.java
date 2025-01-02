package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";  // return 하면 템플릿에서 찾음
    }

    @PostMapping("/members/new")            // data를 form에 넣어서 전달할 때 PostMapping 그래서 위에 똑같은 주소가 있지만 여기로 온다?
    public String create(MemberForm form){     // 그리고 받아온 name을 MemberForm의 String name의 setter로 넣어줌
        Member member = new Member();
        member.setName(form.getName());        // 그래서 getName으로 꺼낸 것

        memberService.join(member);
        return "redirect:/";                   // root로 돌아가기
    }

}
